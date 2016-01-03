package tech.spencercolton.token.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import tech.spencercolton.token.Util.TokenManager;

/**
 * @author Spencer Colton
 */
public class TokensCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String... args) {
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage(ChatColor.RED + "This command cannot be run from the console.");
            return true;
        }

        if(args.length != 0)
            return false;

        sender.sendMessage(ChatColor.GOLD + "You have " + TokenManager.tokenAmount((Player)sender) + " token(s).");
        return true;
    }

}
