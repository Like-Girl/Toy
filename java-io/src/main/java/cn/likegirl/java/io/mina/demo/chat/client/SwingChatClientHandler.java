package cn.likegirl.java.io.mina.demo.chat.client;

import cn.likegirl.java.io.mina.demo.chat.ChatCommand;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;


/**
 * {@link IoHandler} implementation of the client side of the simple chat protocol.
 *
 * @author waylau.com
 * @date 2015-4-6
 */
public class SwingChatClientHandler extends IoHandlerAdapter {

    public interface Callback {
        void connected();

        void loggedIn();

        void loggedOut();

        void disconnected();

        void messageReceived(String message);

        void error(String message);
    }

    private final Callback callback;

    public SwingChatClientHandler(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        callback.connected();
    }

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        String theMessage = (String) message;
        String[] result = theMessage.split(" ", 3);
        String status = result[1];
        String theCommand = result[0];
        ChatCommand command = ChatCommand.valueOf(theCommand);

        if ("OK".equals(status)) {

            switch (command.toInt()) {

                case ChatCommand.BROADCAST:
                    if (result.length == 3) {
                        callback.messageReceived(result[2]);
                    }
                    break;
                case ChatCommand.LOGIN:
                    callback.loggedIn();
                    break;

                case ChatCommand.QUIT:
                    callback.loggedOut();
                    break;
            }

        } else {
            if (result.length == 3) {
                callback.error(result[2]);
            }
        }
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        callback.disconnected();
    }

}
