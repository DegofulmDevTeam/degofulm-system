package listeners;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceSelfDeafenEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceSelfMuteEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class voiceListener extends ListenerAdapter{
	
	
    //Timestamp
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    EmbedBuilder builder = new EmbedBuilder();

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
        //voicelog message
        try {
            //user has at least one role
            builder.setDescription("**[" + event.getMember().getRoles().get(0).getName() + "] " + event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + "** betrat **" + event.getChannelJoined().getName() + "**.");
            builder.setFooter(getCurrentTimeStamp(), null);
            builder.setColor(Color.GREEN);
            event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(builder.build()).queue();
        } catch (Exception e) {
            //user doesn't have any roles
            builder.setDescription("**" + event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + "** betrat **" + event.getChannelJoined().getName() + "**.");
            builder.setFooter(getCurrentTimeStamp(), null);
            builder.setColor(Color.GREEN);
            event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(builder.build()).queue();
        }
    }
    

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event)  {
        //voicelog message
        try {
            //user has at least one role
            builder.setDescription("**[" + event.getMember().getRoles().get(0).getName() + "] " + event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + "** verlie� **" + event.getChannelLeft().getName() + "**.");
            builder.setFooter(getCurrentTimeStamp(), null);
            builder.setColor(Color.RED);
            event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(builder.build()).queue();
        } catch (Exception e) {
            //user doesn't have any roles
            builder.setDescription("**" + event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + "** verlie� **" + event.getChannelLeft().getName() + "**.");
            builder.setFooter(getCurrentTimeStamp(), null);
            builder.setColor(Color.RED);
            event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(builder.build()).queue();
        }
    }

    public void onGuildVoiceMove(GuildVoiceMoveEvent event)  {
        //voicelog message
        try {
            //user has at least one role
            builder.setDescription("**[" + event.getMember().getRoles().get(0).getName() + "] " + event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + "** wechselte von **" + event.getChannelLeft().getName() + "** nach **" + event.getChannelJoined().getName() + "**.");
            builder.setFooter(getCurrentTimeStamp(), null);
            builder.setColor(Color.ORANGE);
            event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(builder.build()).queue();
        } catch (Exception e) {
            //user has at least one role
            builder.setDescription("**" + event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + "** wechselte von **" + event.getChannelLeft().getName() + "** nach **" + event.getChannelJoined().getName() + "**.");
            builder.setFooter(getCurrentTimeStamp(), null);
            builder.setColor(Color.ORANGE);
            event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(builder.build()).queue();
        }
    }

    public void onGuildVoiceSelfMute(GuildVoiceSelfMuteEvent event) {
        //voicelog message
        try {
            //user has at least one role
            builder.setDescription("**[" + event.getMember().getRoles().get(0).getName() + "] " + event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + "** toggled **mute**.");
            builder.setFooter(getCurrentTimeStamp(), null);
            builder.setColor(Color.LIGHT_GRAY);
            event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(builder.build()).queue();
        } catch (Exception e) {
            //user has at least one role
            builder.setDescription("**" + event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + "** toggled **mute**.");
            builder.setFooter(getCurrentTimeStamp(), null);
            builder.setColor(Color.LIGHT_GRAY);
            event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(builder.build()).queue();
        }
    }

    public void onGuildVoiceSelfDeafen(GuildVoiceSelfDeafenEvent event) {
        //voicelog message
        try {
            //user has at least one role
            builder.setDescription("**[" + event.getMember().getRoles().get(0).getName() + "] " + event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + "** toggled **Ton**.");
            builder.setFooter(getCurrentTimeStamp(), null);
            builder.setColor(Color.GRAY);
            event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(builder.build()).queue();
        } catch (Exception e) {
            //user has at least one role
            builder.setDescription("**" + event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + "** toggled **Ton**.");
            builder.setFooter(getCurrentTimeStamp(), null);
            builder.setColor(Color.GRAY);
            event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(builder.build()).queue();
        }
    }
}


