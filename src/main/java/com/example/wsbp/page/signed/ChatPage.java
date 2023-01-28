package com.example.wsbp.page.signed;

import com.example.wsbp.data.Chat;
import com.example.wsbp.service.IUserService;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation(Roles.USER)
@MountPath("Chat")
public class ChatPage extends WebPage {

    @SpringBean
    private IUserService userService;

    public ChatPage(IModel<String> userNameModel) {
        var userMsgModel = Model.of("");

        var userNameLabel = new Label("userName", userNameModel);
        add(userNameLabel);

        var userMassageForm = new Form<>("userMsgForm") {
            @Override
            protected void onSubmit() {
                var userName = userNameModel.getObject();
                var userMsg = userMsgModel.getObject();
                var msg = userName
                        + "の送信データ: "
                        + userMsg;
                System.out.println(msg);
                userService.registerMassage(userName, userMsg);
            }
        };
        add(userMassageForm);

        var userMassageField = new TextField<>("msgBody", userMsgModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(StringValidator.lengthBetween(1, 64));
            }
        };
        userMassageForm.add(userMassageField);

        var chatsModel = Model.ofList(userService.findChats());

        var chstsLV = new ListView<>("chats", chatsModel) {
            @Override
            protected void populateItem(ListItem<Chat> listItem) {
                var itemModel = listItem.getModel();
                Chat chat = itemModel.getObject();
                var userNameModel = Model.of(chat.getUserName());
                var userNameLabel = new Label("userName", userNameModel);
                listItem.add(userNameLabel);

                var userMassageModel = Model.of(chat.getMsgBody());
                var userMassageLabel = new Label("userMsg", userMassageModel);
                listItem.add(userMassageLabel);
            }
        };
        add(chstsLV);

        var toSignedpage = new BookmarkablePageLink<>("toSigned", SignedPage.class);
        add(toSignedpage);
    }

}
