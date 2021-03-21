package com.translation.rxjava1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("jiao","onCreate start >>>>>>>>>");
        doFutureTask();
//        flatMapPrintId();
        Log.i("jiao","onCreate end >>>>>>>>>>>");
    }


    private String doFutureTask(){
        Log.i("jiao","doFutureTask start >>>>>>>>>");
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(4000);
                Log.i("jiao","Callable call() >>>>>>>>>>>");
                return "call";
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i("jiao","Callable call() >>>>>>>>>>>");
            }
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);
        ExecutorService executors = Executors.newCachedThreadPool();

        for (int i = 0;i < 10;i++){
            executors.submit(runnable);
        }

//        Future<String> future = (Future<String>) executors.submit(futureTask);
//        Feature feature = Executors.submit(runnable);
//        executors.execute(futureTask);

//        try {
//            String isDone = futureTask.get();
//            String isDone =  future.get();
//            Log.i("jiao","doFutureTask isDone=");
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        Log.i("jiao","doFutureTask end >>>>>>>>>>");
        return "null";
    }

    private class CachedThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
//            Thread thread = new Thread(r);
            Log.i("jiao"," CachedThreadFactory create thread ");
            return new Thread(r);
        }
    }


    private void flatMapPrintId() {
        List<Person> personList = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {
            List<Plan> planList = new ArrayList<>(3);
            for (int j = 0; j < 3; j++) {
                Plan plan = new Plan();
                plan.setTargetId(i);
                plan.setContent(i == 0 ? "Jack" + j : "Tom" + j);
                planList.add(plan);
            }

            Person person = new Person();
            person.setName(i == 0 ? "Jack" : "Tom");
            person.setPlanList(planList);
            personList.add(person);
        }

        Observable.from(personList)
                .flatMap(new Func1<Person, Observable<Plan>>() {
                    @Override
                    public Observable<Plan> call(Person person) {
                        return Observable.from(person.getPlanList());
                    }
                })
                .subscribe(new Action1<Plan>() {
                    @Override
                    public void call(Plan plan) {
                        Log.i("jiao", " plan " + plan.getTargetId());
                    }
                });

//        Observable.fromIterable(personList)
//                .flatMap((Function<Person, ObservableSource<Plan>>) person -> Observable.fromIterable(person.getPlanList()))
//                .subscribe(plan -> {
////                  Log.i("jiao"," plan "+plan.getContent());
//                    Log.i("jiao", " plan " + plan.getTargetId());
//                });
    }
}