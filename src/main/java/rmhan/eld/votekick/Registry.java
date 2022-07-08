package rmhan.eld.votekick;

import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eld.bukkit.ComponentsRegistry;
import com.ericlam.mc.eld.registration.CommandRegistry;
import com.ericlam.mc.eld.registration.ListenerRegistry;
import org.bukkit.event.Listener;

public class Registry implements ComponentsRegistry {

    @Override
    public void registerCommand(CommandRegistry<CommandNode> commandRegistry) {
        commandRegistry.command(VoteKickCMD.class,c->{
            c.command(VoteKickCreateCMD.class);
            c.command(VoteKickYesCMD.class);
            c.command(VoteKickNoCMD.class);
        });
    }

    @Override
    public void registerListeners(ListenerRegistry<Listener> listenerRegistry) {

    }
}
