
# currency-rate-provider
* Kafka будет использована в качестве шины для коннекта между сервисами(ЕЩЕ НЕ ДОБАВЛЕНА) 
* Удобный инструмент для получения текущих и исторических курсов валют.
* На заданную дату для заданной валюты сервис должен вернуть курс. 
* Курс валюты - отношение рубля к иностранной валюте.

## Использованные технологии
* **Java**
* Spring Boot
* **Kubernetes**
* Gradle(package manager to manipulate with dependecies)

## Для чего этот проект ?
* Проект учебный, для тренировки создания микросервисов, работы с технологиями kafka, kubernetes.

## Источники курса:
* Сайт ЦБ РФ (данные обновляются раз в день)
* предполагается наличие множества других источников (например, имеющих более высокую частоту обновления, таким образом обосновывается использование мс архитектуры - для работы с такими источниками может потребоваться больше ресурсов, в то время как на остальные нагрузка будет меньше - соответственно вертикальное масштабирование в случае монолитного проекта будет не таким выгодным, как горизонтальное при мс архитектуре) 

## Клиент:
* Отправляет запрос: источник курса, дата, валюта
* Получает: значение курса

## Требования:
* Система должна работать с минимально возможным простоем.
* Система должна иметь возможность горизонтального масштабирования


