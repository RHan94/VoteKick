package rmhan.eld.votekick.Commands;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eldgui.InventoryService;
import com.ericlam.mc.eldgui.UIDispatcher;
import com.ericlam.mc.eldgui.UINotFoundException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rmhan.eld.votekick.KickManager;

import javax.inject.Inject;

@Commander(name="panel",description = "快速開啟投票介面",playerOnly = true)
public class VoteKickPanelCMD implements CommandNode {
    @Inject
    private KickManager kickManager;
    @Inject
    @Override
    public void execute(CommandSender sender) {
        if (kickManager.getStatus()){
            Player player = (Player) sender;
            try {
                UIDispatcher dispatcher = inventoryService.getUIDispatcher("main");
                dispatcher.openFor(player);
            } catch (UINotFoundException e) {
                player.sendMessage("UI not found.");
            }
        }else{
            sender.sendMessage("目前沒有投票被發起");
        }
    }
    @Inject
    private InventoryService inventoryService;

}
