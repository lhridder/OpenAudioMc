package net.openaudiomc.commands;

import net.openaudiomc.files.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import net.openaudiomc.players.Sessions;
import net.openaudiomc.socket.TimeoutManager;
import org.bukkit.entity.Player;

public class AudioCommands implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    TimeoutManager.requestConnect();
    if (TimeoutManager.ioready) {

      if (args.length == 2) {
        if (args[0].equalsIgnoreCase("volume") || args[0].equalsIgnoreCase("v")) {
          Player p = (Player) sender;
          p.chat("/volume " + args[1]);
          return true;
        }
      }

      String url = Messages.getColor("website-url");
      url = url.replace("%name%", sender.getName());
      url = url.replace("%session%", Sessions.get(sender.getName()));

      String message = Messages.getColor("connect-message");

      ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
      String command = "tellraw "
          + sender.getName()
          + " "
          + "[\"\",{\"text\":\""
          + message
          + "\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\""
          + url
          + "\"}}]"
          + "";
      Bukkit.dispatchCommand(console, command);
    } else {
      sender.sendMessage(Messages.getColor("socketio-loading"));
    }
    return true;
  }
}
