package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

/**
 * Created by pawelek on 06.07.16.
 */
public class BetterRadar {

    private PatriotBattery patriotBattery;
    private Executor executor;

    public BetterRadar(PatriotBattery patriotBattery, Executor executor) {
        this.patriotBattery = patriotBattery;
        this.executor = executor;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    patriotBattery.launchPatriot();
                }
            }
        });
    }

}
