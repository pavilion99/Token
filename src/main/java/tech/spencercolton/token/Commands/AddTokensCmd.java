package tech.spencercolton.token.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.spencercolton.token.Util.TokenManager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Spencer Colton
 */
public class AddTokensCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String... args) {
        if(args.length != 2)
            return false;

        Stream<? extends Player> s = Bukkit.getOnlinePlayers().stream().filter(p -> p.getName().equals(args[0]));
        List<Player> players = s.collect(Collectors.toList());
        assert !(players.size() > 1);

        Player p = null;

        switch(players.size()) {
            case 0: {
                sender.sendMessage(ChatColor.RED + "Couldn't find a player with that name.");
                return true;
            }
            case 1: {
                p = players.get(0);
                break;
            }
        }

        assert p != null;

        int i;
        try {
            i = Integer.parseInt(args[1]);
        } catch(NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "Invalid number format.");
            return true;
        }

        TokenManager.addToken(p, i);

        sender.sendMessage(ChatColor.GOLD + "Added " + i + " token(s) to " + p.getDisplayName() + "'s account.  New Total: " + TokenManager.tokenAmount(p));
        return true;
    }

}
