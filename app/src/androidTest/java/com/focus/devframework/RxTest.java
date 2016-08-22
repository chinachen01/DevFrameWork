package com.focus.devframework;

import android.test.InstrumentationTestCase;
import android.util.Log;

import rx.Subscriber;

/**
 * Created by focus on 16/8/22.
 */
public class RxTest extends InstrumentationTestCase {

    public void testRxTest() {
        rx.Observable<String> myObservalbe = rx.Observable.create(new rx.Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello, world!");
                subscriber.onCompleted();
            }
        });
        rx.Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d("tag", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("tag", "onNext:" + s);
            }
        };
        myObservalbe.subscribe(mySubscriber);
    }
}
