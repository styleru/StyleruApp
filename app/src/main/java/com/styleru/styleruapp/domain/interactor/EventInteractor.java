package com.styleru.styleruapp.domain.interactor;

import com.styleru.styleruapp.domain.repository.IUserDataRepository;
import com.styleru.styleruapp.presentation.main_screen.events_screen.EventItem;

import javax.inject.Inject;

public class EventInteractor {
    private IUserDataRepository mRepository;
    @Inject
    EventInteractor(IUserDataRepository repository){
        this.mRepository = repository;
    }

    public EventItem getEvent(String id) {
        return mRepository.getEvent("id");
    }
}
