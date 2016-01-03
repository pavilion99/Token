package tech.spencercolton.token;

import org.bukkit.plugin.java.JavaPlugin;
import tech.spencercolton.token.Commands.AddTokensCmd;
import tech.spencercolton.token.Commands.TokensCmd;

public class Token extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("addtokens").setExecutor(new AddTokensCmd());
        this.getCommand("tokens").setExecutor(new TokensCmd());
    }

}
