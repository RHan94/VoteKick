package rmhan.eld.votekick.LogPanel;

import com.ericlam.mc.eldgui.component.factory.ButtonFactory;
import com.ericlam.mc.eldgui.view.UIContext;
import com.ericlam.mc.eldgui.view.View;
import com.ericlam.mc.eldgui.view.ViewDescriptor;
import org.bukkit.Material;

@ViewDescriptor(
        name = "歷史紀錄",
        rows = 1,
        patterns = {"BZZZIZZZP"},
        cancelMove = {'P','I','N'}
)
public class LogPanelView implements View<String> {
    @Override
    public void renderView(String model, UIContext context) {
        ButtonFactory button = context.factory(ButtonFactory.class);
        context.pattern('P').components(
                button.icon(Material.RED_STAINED_GLASS_PANE)
                .create()
        );
        context.pattern('I').components(
                button.icon(Material.PAPER)
                        .create()
        );
        context.pattern('N').components(
                button.icon(Material.GREEN_STAINED_GLASS_PANE)
                        .create()
        );
    }
}
