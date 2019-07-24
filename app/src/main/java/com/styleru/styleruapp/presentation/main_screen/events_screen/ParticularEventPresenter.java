package com.styleru.styleruapp.presentation.main_screen.events_screen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.domain.interactor.EventInteractor;

import javax.inject.Inject;

@InjectViewState
public class ParticularEventPresenter extends MvpPresenter<ParticularEventView> {
    private EventInteractor mEventInteractor;
    @Inject
    ParticularEventPresenter(EventInteractor eventInteractor){
        mEventInteractor = eventInteractor;
    }
    void provideData(String id){
        EventItem item = mEventInteractor.getEvent(id);
        getViewState().showData(item);
    }
}
