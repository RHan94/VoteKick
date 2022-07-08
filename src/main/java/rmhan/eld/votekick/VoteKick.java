package rmhan.eld.votekick;

import com.ericlam.mc.eld.BukkitManagerProvider;
import com.ericlam.mc.eld.ELDBukkit;
import com.ericlam.mc.eld.ELDBukkitPlugin;
import com.ericlam.mc.eld.ServiceCollection;
@ELDBukkit(
        registry = Registry.class, //指向註冊class
        lifeCycle = LifeCycle.class //指向生命週期class
)
public final class VoteKick extends ELDBukkitPlugin {


    @Override
    protected void manageProvider(BukkitManagerProvider bukkitManagerProvider) {

    }

    @Override
    public void bindServices(ServiceCollection serviceCollection) {
        serviceCollection.addSingleton(KickInfo.class);
    }
}
