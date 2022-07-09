package rmhan.eld.votekick;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;

@Commander(name = "reload",description = "重新讀取插件設定檔",permission = "vk.permission")
public class VoteKickConfigReloadCMD implements CommandNode {
    @Inject
    private KickConfig config;
    @Override
    public void execute(CommandSender sender) {
        config.getController().reload();
        sender.sendMessage("重新讀取完畢");
    }
}
