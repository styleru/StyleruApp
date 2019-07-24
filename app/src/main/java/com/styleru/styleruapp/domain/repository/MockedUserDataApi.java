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
                "java meetup", "31.12.2018", "red square", "Я сдуваю с МАКа пепел, под рукой бумага RAW\n" +
                "Мертвый молодой ублюдок, с виду будто Рассел Кроу\n" +
                "Прохожу насквозь, они молчат\n" +
                "Из могилы по ночам\n" +
                "Я встаю, чтобы сказать им, что их рэп — ебаный чат\n" +
                "И я заберу твой рубль, прикурю от него блант\n" +
                "Твоя телка на коленях отработает марант\n" +
                "Худощавый мертвый рэпер отберет у тебя жизнь\n" +
                "Если Фара в своей зоне, от него не убежишь\n" +
                "Я криповый, будто Джиперс, под плащом держу топор\n" +
                "Кадиллак дымит за милю, ты попал под его взор\n" +
                "Я скитаюсь по бульварам\n" +
                "Мертвый белый в тени вод\n" +
                "Я сдуваю с МАКа пепел, после поджигаю лед\n" +
                "Дым — вон, телефон, две сим-карты, десять тонн\n" +
                "Пакет морса, тапки в мясо, безупречен — Куинси Джонс\n" +
                "Курсив — твой клинок, лонгслив — эпилог\n" +
                "На моих глазах усталость, я стал тем, кем ты не смог (тварь!)\n" +
                "\n" +
                "[Припев]\n" +
                "Мы не знакомы, я не знаю, кто вы\n" +
                "Я кручу фруктовый на крышке гроба\n" +
                "Мы не знакомы, я не знаю, кто вы\n" +
                "Я кручу фруктовый на крышке гроба\n" +
                "Мы не знакомы, я не знаю, кто вы\n" +
                "Я кручу фруктовый на крышке гроба\n" +
                "Мы не знакомы, я не знаю, кто вы\n" +
                "Я кручу фруктовый на крышке гроба");
    }
}
