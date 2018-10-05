package core;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.exceptions.RateLimitedException;


import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] Args) throws RateLimitedException {

        JDABuilder builder = new JDABuilder(AccountType.BOT);

        builder.setToken("NDk3NzYwMzczNTY3NTIwNzY5.Dpj4Tg.FEU6kF_o_9kg-r7dL_kVj8aW1kM");
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);

        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}