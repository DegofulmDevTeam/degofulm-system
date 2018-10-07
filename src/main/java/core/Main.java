package core;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.login.LoginException;

import listeners.botJoinListener;
import listeners.readyListener;
import listeners.userJoinListener;

public class Main {

    public static void main(String[] Args) throws RateLimitedException, IOException {
    	
    	//Console Input for Token
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.print("Please Enter Token from Discord Dev Portal: \n");
        String USERTOKEN = br.readLine();
        
    	
    	//Create new JDA Instance
    	JDABuilder builder = new JDABuilder(AccountType.BOT);

        builder.setToken(USERTOKEN); //Set Token for logging into Discord
        builder.setAutoReconnect(true); //Enable Automatic Reconnect in case the bot looses Coonection
        
        

        builder.setStatus(OnlineStatus.ONLINE); //Set Discord online Status to Online
        
        //register Listeners
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