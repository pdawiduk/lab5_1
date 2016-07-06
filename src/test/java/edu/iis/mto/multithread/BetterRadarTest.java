package edu.iis.mto.multithread;


import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.*;

/**
 * Created by pawelek on 06.07.16.
 */
public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @RepeatRule.Repeat(times = 10)
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
