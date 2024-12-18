1.Що таке immutable об’єкт? Для чого об’єкти класу String зробили імутабельними? Чому клас String задекларований як final?

    Immutable об’єкт — це об’єкт, стан якого не може змінюватися після створення. Наприклад, якщо ви створили об’єкт класу String, його значення не може бути змінене після ініціалізації. Замість цього створюється новий об’єкт при будь-яких змінах.
    Імутабельність об’єктів String забезпечує:
        Безпеку: Об’єкти String часто використовуються в багатопоточному середовищі (наприклад, у ключах HashMap), і їх незмінність запобігає проблемам синхронізації.
        Продуктивність: Імутабельність дозволяє кешувати значення (наприклад, у String Pool), що знижує витрати на створення нових об’єктів.
        Захист від змін: Якщо передати об’єкт String в метод, його значення залишиться незмінним.
    Клас String задекларований як final, щоб уникнути наслідування та можливості зміни поведінки, що могло б порушити принцип імутабельності.

2.Що таке регулярні вирази? Наведіть приклади регулярних виразів.
Регулярні вирази (Regular Expressions, regex) — це шаблони, що використовуються для пошуку та обробки тексту. Вони дозволяють визначати складні критерії пошуку, перевірки або заміни.

    Приклади регулярних виразів:
        \d+ — знаходить одну або більше цифр.
        [a-zA-Z]+ — знаходить одну або більше літер латиниці (великих або малих).
        ^hello — текст, що починається з "hello".
        .*@.*\..* — перевіряє простий формат електронної пошти.
        \bcat\b — знаходить слово "cat" у межах слова.

3.В чому полягає різниця між оператором «==» та методом «equals()»?

    == перевіряє, чи вказують дві змінні на той самий об'єкт у пам'яті (посилання).
    equals() перевіряє логічну рівність об’єктів, тобто чи мають вони однаковий зміст.
    Наприклад:

String s1 = "hello";
String s2 = new String("hello");

System.out.println(s1 == s2); // false (різні об’єкти в пам’яті)
System.out.println(s1.equals(s2)); // true (однаковий зміст)

4.Для чого потрібні класи StringBuilder та StringBuffer?

    StringBuilder і StringBuffer використовуються для створення змінних (mutable) рядків, які можна редагувати без створення нових об’єктів.
    StringBuilder швидший, але не синхронізований, тому підходить для роботи в одному потоці.
    StringBuffer синхронізований і безпечний для багатопоточного середовища, але повільніший.
    Приклади використання:

StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb.toString()); // "Hello World"

5.Яким чином простіше всього прибрати пробіли на початку та кінці об’єкту String?
Найпростіший спосіб — використати метод trim() класу String, який видаляє пробіли на початку та кінці рядка:

String str = "   Hello World   ";
System.out.println(str.trim()); // "Hello World"

Якщо потрібно видалити всі пробіли на початку та кінці, включаючи табуляцію та нові рядки, можна використати регулярний вираз:

String str = "   \nHello World\t  ";
System.out.println(str.strip()); // "Hello World" (Java 11+)