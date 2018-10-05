package core;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.exceptions.RateLimitedException;


import javax.security.auth.login.LoginException;

import listeners.botJoinListener;
import listeners.readyListener;
import listeners.userJoinListener;

public class Main {

    public static void main(String[] Args) throws RateLimitedException {

        JDABuilder builder = new JDABuilder(AccountType.BOT);

        builder.setToken("<PLACE TOKEN HERE>");
        builder.setAutoReconnect(true);
        
        

        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        
        builder.addEventListener(new readyListener());
        builder.addEventListener(new botJoinListener());
        builder.addEventListener(new userJoinListener());
        
        
        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}