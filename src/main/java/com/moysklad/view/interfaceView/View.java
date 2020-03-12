package com.moysklad.view.interfaceView;

import java.util.List;

/**
 * Класс отображает интерфейс пользователя.
 */
public interface View {
    /**
     * Ищет все данные из базы данных и добавляет объекты в список.
     * @return список объектов.
     */
    List<View> findAllView();
}
