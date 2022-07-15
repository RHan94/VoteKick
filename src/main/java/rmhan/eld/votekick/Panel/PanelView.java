package rmhan.eld.votekick.Panel;

import com.ericlam.mc.eldgui.component.factory.ButtonFactory;
import com.ericlam.mc.eldgui.view.UIContext;
import com.ericlam.mc.eldgui.view.View;
import com.ericlam.mc.eldgui.view.ViewDescriptor;
import org.bukkit.Material;

@ViewDescriptor(
        name = "投票頁面",
        rows = 3,
        patterns = {"ZZZZIZZZZ","ZAZZZZZZ","ZZZZZZZDZ"},
        cancelMove = {'I','A','D'}
)

public class PanelView implements View<String>{
    @Override
    public void renderView(String model, UIContext context) {
        ButtonFactory button = context.factory(ButtonFactory.class); // Button 是展示類組件
        context.pattern('I')
                .components(
                        button.icon(Material.DIAMOND_BLOCK)
                                .title("§e投票資訊")
                                .lore(model)
                                .create()
                );
        context.pattern('A')
                .components(
                    button.icon(Material.GREEN_STAINED_GLASS_PANE)
                        .title("§a同意")
                        .create()
        );
        context.pattern('D')
                .components(
                        button.icon(Material.GREEN_STAINED_GLASS_PANE)
                                .title("§c不同意")
                                .create()
                );
    }
}