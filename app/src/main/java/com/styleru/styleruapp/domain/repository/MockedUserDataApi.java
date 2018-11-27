package com.styleru.styleruapp.domain.repository;

import com.styleru.styleruapp.presentation.main_screen.events_screen.EventItem;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.LinkItem;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.ProfileModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MockedUserDataApi implements IUserDataApi{
    @Inject
    MockedUserDataApi(){}

    @Override
    public boolean isInfoCorrect(String login, String password) {
        return login.equals("guest") && password.equals("1234");
    }

    @Override
    public ProfileModel getProfile(String id) {
        List<LinkItem> links = new ArrayList<>();
        links.add(new LinkItem("VK", "id4920"));
        links.add(new LinkItem("Instagram", "ngneecwmk.com"));
        links.add(new LinkItem("лицокнига", "navalnyi2018.com"));
        links.add(new LinkItem("лицокнига", "navalnyi2018.com"));
        links.add(new LinkItem("лицокнига", "navalnyi2018.com"));
        links.add(new LinkItem("лицокнига", "navalnyi2018.com"));
        links.add(new LinkItem("лицокнига", "navalnyi2018.com"));
        links.add(new LinkItem("Instagram", "ngneecwmk.com"));
        links.add(new LinkItem("лицокнига", "navalnyi2018.com"));
        links.add(new LinkItem("Instagram", "ngneecwmk.com"));
        links.add(new LinkItem("лицокнига", "navalnyi2018.com"));
        links.add(new LinkItem("Instagram", "ngneecwmk.com"));
        links.add(new LinkItem("лицокнига", "navalnyi2018.com"));
        links.add(new LinkItem("Instagram", "ngneecwmk.com"));
        links.add(new LinkItem("лицокнига", "navalnyi2018.com"));
        links.add(new LinkItem("Instagram", "ngneecwmk.com"));
        links.add(new LinkItem("Яйцоокнига", "navalnyi2018.com"));

        ProfileModel mSampleProfile = new ProfileModel("Vlad","Yundin",
                "Android",
                "https://pp.userapi.com/c836234/v836234471/2fc01/CfB0TIHo8zE.jpg?ava=1",
                "ci1p24qh93rrk92k91",
                "null@gmail.com",
                "88005553535",
                links);
        return mSampleProfile;
    }

    @Override
    public EventItem getEvent(String id) {
        return new EventItem("https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Bufotes_oblongus.jpg/275px-Bufotes_oblongus.jpg",
                "java meetup", "31.12.2018", "red square");
    }
}
