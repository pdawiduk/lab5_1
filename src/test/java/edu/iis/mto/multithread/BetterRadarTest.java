package edu.iis.mto.multithread;

import org.junit.Test;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by pawelek on 06.07.16.
 */
public class BetterRadarTest {

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery patriotBattery = mock(PatriotBattery.class);
        Executor executor = new Executor() {

            @Override
            public void execute(Runnable runnable) {
                runnable.run();
            }
        };
        BetterRadar betterRadar = new BetterRadar(patriotBattery, executor);
        betterRadar.notice(new Scud());
        verify(patriotBattery, times(10)).launchPatriot();
    }

}
