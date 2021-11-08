package ru.arvalon.hellokotlin.book.ch4

class Button2: View {

    val foo = "MyStr"

    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    // статический класс, аналог static в Java, не имеет не явной ссылки на окружающий экземпляр
    class ButtonState: State{
        // какая-нибудь реализация сериализации
    }

    // Объявдение Inner (в Java был бы просто class без модификатора) делает возможным получить ссылку на окружающий экземпляр
    inner class InnterClass{
        fun getOuterReference(): Button2 = this@Button2
        fun getOuterReferenceWithoutType() = this@Button2
    }
}