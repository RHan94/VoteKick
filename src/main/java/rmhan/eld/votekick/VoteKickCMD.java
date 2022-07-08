package rmhan.eld.votekick;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import org.bukkit.command.CommandSender;
@Commander(
        name="votekick",
        description = "Voted For Kick Somebody",
        alias = ("vk"),
        playerOnly = true
)
public class VoteKickCMD implements CommandNode {
    @Override
    public void execute(CommandSender sender) {

    }
}
