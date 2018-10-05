package listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


public class botJoinListener extends ListenerAdapter {


		public void onGuildJoin(GuildJoinEvent event) {
		
			System.out.println(event.getGuild().getName() + " hat den Bot hinzugefuegt");
			
	}


}
