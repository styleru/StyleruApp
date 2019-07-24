package com.styleru.styleruapp.presentation.main_screen.events_screen;

import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class EventsPresenter extends MvpPresenter<EventsView> {
    private final StyleruRouter mRouter;

    @Inject
    EventsPresenter(StyleruRouter router) {
        this.mRouter = router;
    }

    void changeScreen(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.directions_menu:
                mRouter.replaceScreen(ScreenKeys.DIRECTIONS_FRAGMENT);
                break;
            case R.id.people_menu:
                mRouter.replaceScreen(ScreenKeys.PEOPLE_FRAGMENT);
                break;
            case R.id.profile_menu:
                mRouter.replaceScreen(ScreenKeys.PROFILE_FRAGMENT);
                break;
        }
    }

    void moveToEvent(){
        mRouter.navigateTo(ScreenKeys.PARTICULAR_EVENT);
    }

    void provideData(){
        EventItem sampleProfile = new EventItem("https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Bufotes_oblongus.jpg/275px-Bufotes_oblongus.jpg", "java meetup", "31.12.2018", "red square", "Я сдуваю с МАКа пепел, под рукой бумага RAW\n" +
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
        List<EventItem> profiles = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            profiles.add(sampleProfile);
        }
        getViewState().showData(profiles);
    }
}
