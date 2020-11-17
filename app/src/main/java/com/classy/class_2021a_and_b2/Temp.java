package com.classy.class_2021a_and_b2;

public class Temp {

    /*
    The handler run on mainThread (uiThread)

    final Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        public void run() {
            handler.postDelayed(this, DELAY);
            secondlyFunction();
        }
    };

    private void startCounting() {
        handler.postDelayed(runnable, DELAY);
    }

    private void stopCounting() {
        handler.removeCallbacks(runnable);
    }
     */




    /*
    scheduleWithFixedDelay - Continual delay
    scheduleAtFixedRate - fixed time in accurate time

    UI methods must run on mainThread (uiThread)


    ScheduledFuture scheduledFuture;

    private void startCounting() {
        scheduledFuture = new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Log.d("ptttT", "B:" + Thread.currentThread().getName());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("ptttT", "C:" + Thread.currentThread().getName());
                        secondlyFunction();
                    }
                });
            }
        }, 0l, DELAY,  TimeUnit.MILLISECONDS);
    }

    private void stopCounting() {
        scheduledFuture.cancel(false);
    }
     */




    /*
    UI methods must run on mainThread (uiThread)

    fixed time in accurate time




    private Timer carousalTimer;

    private void startCounting() {
        carousalTimer = new Timer();
        carousalTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        secondlyFunction();
                    }
                });
            }
        }, 0, DELAY);
    }

    private void stopCounting() {
        carousalTimer.cancel();
    }
     */
}
