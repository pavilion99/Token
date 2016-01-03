package tech.spencercolton.token.Util;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Spencer Colton
 */
public class TokenManager {

    private static Map<Player, Integer> tokens = new HashMap<>();

    public static void addToken(Player p, int amount) {
        if(tokens.get(p) == null) {
            tokens.put(p, amount);
            return;
        }

        int j = tokens.get(p);
        j += amount;
        tokens.put(p, j);
    }

    public static int tokenAmount(Player p) {
        return tokens.get(p) == null ? 0 : tokens.get(p);
    }

}
