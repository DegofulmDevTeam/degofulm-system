package listeners;

import java.util.List;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


	public class userJoinListener extends ListenerAdapter {


			public void onGuildMemberJoin(GuildMemberJoinEvent event) {
				
				Member EventMember = event.getMember();
				List<Role> EventRole = event.getGuild().getRolesByName("spieler", true);
			
			event.getGuild().getController().addRolesToMember(EventMember, EventRole).queue();
				
		}


	}


