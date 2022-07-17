package rmhan.eld.votekick.Commands;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.annotations.InjectPool;
import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eld.configurations.GroupConfig;
import com.ericlam.mc.eldgui.InventoryService;
import com.ericlam.mc.eldgui.UIDispatcher;
import com.ericlam.mc.eldgui.UINotFoundException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rmhan.eld.votekick.Logs.VoteLog;

import javax.inject.Inject;

@Commander(name = "logs",description = "顯示歷史投票紀錄")
public class VoteKickLogsCMD implements CommandNode {
    @InjectPool
    private GroupConfig<VoteLog> Logs;
    @Inject
    private InventoryService inventoryService;
    @Override
    public void execute(CommandSender sender) {
            Player player = (Player) sender;
            try {
                UIDispatcher dispatcher = inventoryService.getUIDispatcher("LogController");
                dispatcher.openFor(player);
            } catch (UINotFoundException e) {
                player.sendMessage("UI not found.");
            }
    }
}
