package rmhan.eld.votekick.Commands;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import org.bukkit.command.CommandSender;
import rmhan.eld.votekick.KickManager;

import javax.inject.Inject;

@Commander(
        name="toggle",
        description = "設定伺服器是否能發起投票",
        permission = "vk.admin"
)
public class VoteKickEnableCMD implements CommandNode {
    @Inject
    private KickManager manager;
    @Override
    public void execute(CommandSender sender) {
        manager.ToggleEnable();
        sender.sendMessage("已將投票發起狀態設為:"+ (manager.getEnable() ? "允許":"不允許"));
    }
}
