package com.translation.rxjava3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.schedulers.SchedulerWhen;
import io.reactivex.rxjava3.internal.util.ConnectConsumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.Subject;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView title = findViewById(R.id.text);
        title.setText(Html.fromHtml("\"冻到-18℃去享用<em>野格</em>是最优解\""));

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createObservable();
                just();
                fromCallable();
                time();
                interval();
                map();
                fromFuture();
                flatMap();
                testSubscriptionOn();
            }
        });
    }


    private void createObservable(){

       Observable.create((ObservableOnSubscribe<String>) emitter -> {
            Log.i("jiao"," create subscribe thead  id "+Thread.currentThread().getId());
            emitter.onNext("第一次");
            emitter.onNext("第二次");
            emitter.onComplete();
        })
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i("jiao","onSubScribe "+d.isDisposed());
                    }

                    @Override
                    public void onNext(String o) {
                        Log.i("jiao","onNext accept = "+o+" thead id "+Thread.currentThread().getId());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.i("jiaoa","onComplete..");
                    }
                });
    }

    private void just(){
        Observable.just(1,2,3,4,5,6)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.i("jiao","onNext() "+integer.intValue());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.i("jiao","onComplete()");
                    }
                });
    }

    private void fromCallable(){
        Observable.fromCallable(() -> 10).subscribe(integer -> Log.i("jiao"," accept integer = "+integer));
    }

    private void time(){
        Observable.timer(5, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Long aLong) {
                Log.i("jiao","onNext ... long "+aLong);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void interval(){
        Observable.intervalRange(5,10,2,10,TimeUnit.SECONDS)
//        Observable.interval(3,TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        Log.i("jiao"," interval onNext "+aLong);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void map(){
        Observable.just(1,2,3,4,5,6,7)
                .map(integer -> "apply value = "+integer.intValue())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Log.i("jiaoa","onNext map covert string "+s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.i("jiaoa","onComplete map covert string ");
                    }
                });
    }

    private void fromFuture(){
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Log.d("jiao","FutureTask Callable Demo is Runing");
                return "返回结果";
            }
        });

        Observable.fromFuture(futureTask)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Throwable {
                        Log.i("jiao","fromFuture doOnSubscribe accept() ");
                        futureTask.run();
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Throwable {
                        Log.i("jiao","fromFuture accept "+s);
                    }
                });

    }

    private void flatMap(){

        List<Person> personList = new ArrayList<>(2);
        for (int i = 0 ;i< 2;i++){

            List<Plan> planList = new ArrayList<>(3);
            for (int j = 0;j < 3;j++){
                Plan plan = new Plan(String.valueOf(j),i == 0 ? "我是jiao"+j : "我是zhang"+j);
                planList.add(plan);
            }

            Person person = new Person(i == 0 ? "jiao":"zhang",planList);

            personList.add(person);
        }


        Observable.fromIterable(personList)
                .flatMap(new Function<Person, ObservableSource<Plan>>() {

                    @Override
                    public ObservableSource<Plan> apply(Person person) throws Throwable {
                        if ("jiao".equals(person.getName())) {
                            return Observable.fromIterable(person.getPlanList()).delay(10, TimeUnit.MILLISECONDS);
                        }

                        return Observable.fromIterable(person.getPlanList());
                    }
                })
               .subscribe(new Observer<Plan>() {
                   @Override
                   public void onSubscribe(@NonNull Disposable d) {}

                   @Override
                   public void onNext(@NonNull Plan plan) {
                        Log.i("jiao","flatMap  content "+plan.getContent());
                   }

                   @Override
                   public void onError(@NonNull Throwable e) {}

                   @Override
                   public void onComplete() {}
               });

    }

    private void testSubscriptionOn() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {

                Log.i("jiao"," 1111 Thread id "+Thread.currentThread().getId());
                emitter.onNext("2222222");
            }
        })
                .observeOn(Schedulers.computation())
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Throwable {
                        Log.i("jiao","2222 Thread id "+Thread.currentThread().getId());
                        return "test";
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Log.i("jiao","3333 Thread id "+Thread.currentThread().getId());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
