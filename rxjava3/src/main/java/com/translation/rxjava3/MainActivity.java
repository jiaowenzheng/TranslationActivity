package com.translation.rxjava3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromCallable;
import io.reactivex.rxjava3.observables.GroupedObservable;
import io.reactivex.rxjava3.schedulers.Schedulers;

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
//                createObservable();
//                just();
//                fromCallable();
//                time();
//                interval();
//                map();
//                fromFuture();
//                flatMap();
//                testSubscriptionOn();
//                test();
//                buffer();
//                groupBy();
//                rangeGroupBy();
//                collect();
//                retryUntil();
//                retryWhen();
//                ofType();
//                onTypeObject();
//                skipUntil();
//                testObservable();
//                container();
//                reduce();
//                merge();
//                intervalLoop();
//                repeatWhen();
//                retryWhenTime();
//                zipWith();
                flatMapPrintId();
            }
        });
    }

    private void zipWith(){
        Observable.range(1,3)
                .zipWith(Arrays.asList(1, 2, 3, 4,5,6,7,8,9), new BiFunction<Integer, Integer, String>() {
                    @Override
                    public String apply(Integer i1, Integer i2) throws Throwable {
                        return i1+"-"+i2;
                    }
                }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.i("jiao","onNext value  "+s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void retryWhenTime(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new Throwable("出现异常了"));
                emitter.onNext(4);
            }
        })
                .retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Throwable {
                        return throwableObservable.zipWith(Observable.range(1, 3), new BiFunction<Throwable, Integer, Integer>() {
                            @Override
                            public Integer apply(Throwable o, Integer integer) throws Throwable {
                                Log.i("jiao"," zipWith apply integer "+integer);
                                return integer;
                            }
                        }).flatMap(new Function<Integer, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(Integer integer) throws Throwable {
                                Log.i("jiao"," flatMap apply integer = "+integer);
                                return Observable.timer(3,TimeUnit.SECONDS);
                            }
                        });
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.i("jiao"," onNext value = "+integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("jiao"," onError Message = "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.i("jiao"," onComplete");
                    }
                });
    }

    int repeatCount = 0;
    private void repeatWhen(){
        Observable.just(1,2,3)
        .repeatWhen(objectObservable -> {
            Log.i("jiao","repeatCount ="+repeatCount);
            return objectObservable.zipWith(Observable.range(1, 3), new BiFunction<Object, Integer, Integer>() {
                @Override
                public Integer apply(Object integer, Integer integer2) throws Throwable {
                    Log.i("jiao","zipWith apply integer2 = "+integer2);
                    return integer2;
                }

            }).flatMap(new Function<Integer, ObservableSource<?>>() {
                @Override
                public ObservableSource<?> apply(Integer integer) throws Throwable {
                    Log.i("jiao","flatMap apply integer="+integer);
                    return Observable.timer(3,TimeUnit.SECONDS);
                }
            });
        })
            .subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.i("jiao"," onNext value = "+integer);
                repeatCount++;
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("jiao"," onError Message = "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i("jiao"," onComplete Message = ");
            }
        });
    }

    private void reduce(){
        Observable.just(1,2,3,4,5,6)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer t1, Integer t2) throws Throwable {
                        Log.i("jiao","apply "+t1+"+"+t2);
                        return t1  + t2;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Throwable {
                        Log.i("jiao"," reduce accept integer="+integer);
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

    private void intervalLoop(){
        Observable.interval(1,1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long value) throws Throwable {
                        Log.i("jiao","intervalLoop accept valaue="+value);
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

    private void test(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                emitter.onNext("1111");
                emitter.onNext("2222");
                Log.i("jiao","subscribe accept thead id="+Thread.currentThread().getId());
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Throwable {
                        Log.i("jiao","doOnNext accept thead id="+Thread.currentThread().getId());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Throwable {
                        Log.i("jiao","doOnSubscribe accept thead id="+Thread.currentThread().getId());
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.i("jiao","onNext accept thead id="+Thread.currentThread().getId());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void buffer(){
        Observable.just(1,2,3,4,5)
                .buffer(2,1)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Integer> integers) {
                        Log.i("jiao","=======缓冲区大小："+integers.size());
                        for (Integer i : integers){
                            Log.i("jiao","=========元素："+i);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void groupBy(){
        Observable.just(5, 2, 3, 4, 1, 6, 7, 8, 9, 10)
                .groupBy(integer -> integer % 3)
                .subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i("jiao", "onSubscribe =================");
                    }

                    @Override
                    public void onNext(@NonNull GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {

                        Log.i("jiao", "onNext grou name=================" + integerIntegerGroupedObservable.getKey());

                        integerIntegerGroupedObservable.subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull Integer integer) {
                                Log.i("jiao", " 分组 子元素 ==== " + integer+" group name="+integerIntegerGroupedObservable.getKey());
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void rangeGroupBy(){
        Observable.range(1,8)
                .groupBy(integer -> {
                    Log.i("jiao","range integer = "+integer);
                    Log.i("jiao","range integer ===================================== ");
                    return integer % 2 == 0 ? "偶数" : "奇数";
                }).subscribe(stringIntegerGroupedObservable -> {
                    String key = stringIntegerGroupedObservable.getKey();
                    Log.i("jiao"," rangeGroupBy "+key);

                    if (key.startsWith("奇数")){
                        stringIntegerGroupedObservable.subscribe(new Consumer<Integer>() {
                            @Override
                            public void accept(Integer integer) throws Throwable {
                                Log.i("jiao"," children = "+integer);
                            }
                        });
                    }
                });
    }

    private void collect(){
        Observable.just(1, 2, 3, 4)
                .collect(new ObservableFromCallable<ArrayList<Integer>>(new Callable<ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> call() throws Exception {
                                return new ArrayList<>();
                            }
                        }) ,
                        new BiConsumer < ArrayList < Integer > , Integer > () {
                            @Override
                            public void accept(ArrayList < Integer > integers, Integer integer) throws Exception {
                                integers.add(integer);
                            }
                        })
                .subscribe(new Consumer < ArrayList < Integer >> () {
                    @Override
                    public void accept(ArrayList < Integer > integers) throws Exception {
                        Log.d("TAG", "===============accept " + integers);
                    }
                });
    }

    private void retryUntil(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new Error("101"));
//                emitter.onNext(4);
            }
        }).retryUntil(new BooleanSupplier() {
            @Override
            public boolean getAsBoolean() throws Throwable {
                return true;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i("jiao"," onSubscribe ");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.i("jiao","onNext accept value = "+integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("jiao","onError message = "+e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void retryWhen(){

        //retryWhen和retry类似，
        // 区别是:
        // retryWhen将onError中的Throwable传递给一个函数，这个函数产生另一个Observable，
        // retryWhen观察它的结果再决定是不是要重新订阅原始的Observable。
        //如果这个Observable发射了一项数据，它就重新订阅，
        // 如果这个Observable发射的是onError通知，它就将这个通知传递给观察者然后终止。

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new Error("出错了！"));
                emitter.onNext(4);
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Throwable {
                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Throwable throwable) throws Throwable {
                        return Observable.error(new Error("出错了.......!"));
//                        return Observable.just(1);
                    }
                });
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.i("jiao","onNext retryWhen integer = "+integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("jiao","onError message = "+e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void ofType(){
        List<Object> typeList = new ArrayList<>();
        typeList.add(1);
        typeList.add("你好");
        typeList.add("左右");
        typeList.add(2);
        typeList.add(3);
        typeList.add(4);

        Observable.fromIterable(typeList)
                .ofType(Integer.class)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.i("jiao","ofType onNext integer="+integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {}

                    @Override
                    public void onComplete() {}
                });
    }

    private void onTypeObject(){
        List<Object> list = new ArrayList<>(3);
        list.add(new Person("1",null));
        list.add(new Person("2",null));
        list.add(new Person("3",null));
        list.add(new Person("4",null));
        list.add(new Person("5",null));
        list.add(new Person("3",null));
        list.add(new Plan("111111111111","我是plan"));

        Observable.fromIterable(list)
                .ofType(Person.class)
                .subscribe(new Consumer<Person>() {
                    @Override
                    public void accept(Person person) throws Throwable {
                        Log.i("jiao"," accept name="+person.getName());
                    }
                });
    }

    private void skipUntil(){
        Observable.intervalRange(1,5,0,1,TimeUnit.SECONDS)
                .skipUntil(Observable.intervalRange(6,5,3,1,TimeUnit.SECONDS))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Throwable {
                        Log.i("jiao"," skipUntil accept number "+aLong);
                    }
                });
    }

    private void container(){
        Observable.just(1,2,3,4,5,6,7,8)
                .contains(3)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Throwable {
                        Log.i("jiao"," container accept is contains "+aBoolean);
                    }
                });
    }

    private void testObservable(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                Log.i("jiao","observable create subscribe ............");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i("jiao","onSubscribe ............");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.i("jiao","onNext ............");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("jiao","onError ............");
            }

            @Override
            public void onComplete() {
                Log.i("jiao","onComplete ............");
            }
        });
    }

    private void merge(){
        Observable.merge(
                Observable.intervalRange(0,3,1,1,TimeUnit.SECONDS),
                Observable.intervalRange(2,3,1,1,TimeUnit.SECONDS)
        ).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long value) throws Throwable {
                Log.i("jiao","merge ...... value="+value);
            }
        });
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

        Observable.fromIterable(personList)
                .flatMap((Function<Person, ObservableSource<Plan>>) person -> Observable.fromIterable(person.getPlanList()))
                .map(new Function<Plan, Integer>() {
                    @Override
                    public Integer apply(Plan plan) throws Throwable {
                        return plan.getTargetId();
                    }
                })
                .distinct()
                .collect(new ObservableFromCallable<ArrayList<Integer>>(new Callable<ArrayList<Integer>>() {
                    @Override
                    public ArrayList<Integer> call() throws Exception {
                        return new ArrayList<>();
                    }
                }), new BiConsumer<ArrayList<Integer>, Integer>() {
                    @Override
                    public void accept(ArrayList<Integer> integers, Integer integer) throws Throwable {
                        integers.add(integer);
                    }
                }).subscribe(new Consumer<ArrayList<Integer>>() {
                    @Override
                    public void accept(ArrayList<Integer> integers) throws Throwable {
                        Log.i("jiao"," accept = "+integers.size());
                    }
                });
    }

}
