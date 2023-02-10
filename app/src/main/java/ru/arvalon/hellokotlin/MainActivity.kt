package ru.arvalon.hellokotlin

import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.coroutines.*
import ru.arvalon.hellokotlin.model.Person

import ru.arvalon.hellokotlin.book.ch2.Color.*
import ru.arvalon.hellokotlin.book.ch2.Expr
import ru.arvalon.hellokotlin.book.ch2.Expr.Num
import ru.arvalon.hellokotlin.book.ch2.Expr.Sum
import ru.arvalon.hellokotlin.book.ch2.Expr.Multipl
import ru.arvalon.hellokotlin.book.ch4.*
import ru.arvalon.hellokotlin.book.ch5.Book
import ru.arvalon.hellokotlin.book.ch5.MyPerson
import ru.arvalon.hellokotlin.book.ch6.*
import ru.arvalon.hellokotlin.book.ch7.*
import ru.arvalon.hellokotlin.book.ch8.*
import ru.arvalon.hellokotlin.book.ch9.*
import ru.arvalon.hellokotlin.model.User
import strings.join
import strings.joinToString2
import strings.joinToStringStart2
import strings.lastChar2
import java.io.BufferedReader
import java.io.FileReader
import java.math.BigDecimal
import java.time.LocalDate
import strings.lastChar as last
import java.util.*
import kotlin.collections.ArrayList
import kotlin.text.filter

const val TAG2 = "kotlin.log"

fun MyLog(msg: String){
    Log.d(TAG2, msg)
}

class MainActivity : AppCompatActivity() {

    companion object { val TAG = "kotlin.log" }

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // -----------------------------------------------------------------------------------------

        //Log.d(TAG, "onCreate "+sum(1,2)+" "+sum2(2,4))

        //printSum(1,4)

        //foo()
        //bar()
        //Log.d(TAG,"max =  "+max(2,4))
        //Log.d(TAG,"min =  "+min(2,4))
        //foo2()

        //markerInterface()

        //whileLoops()

        //forLoops()

        //dictionaryIterators()

        //welcomeBack()

        //untilLoop()

        //breaks()

        //rangeTest()

        //printSeparator("Collections")

        //collections1()

        //collections2()

        //stringsRegex()

        //localFunctions()

        //classes()

        //lambdas()

        //TypeSystem()

        //coroutines()

        //coroutines2()

        //coroutines3()

        //coroutines4()

        //coroutines5()

        //coroutines6()

        //coroutines7()

        //coroutines8()

        //coroutines9()

        //operatorOverloading()

        //lazyInitialization()

        //highOrderFunctionsAndLambdasChapter8()

        //generics()

        //reflection()

        palindrome()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun printSeparator(name: String){

        Log.d(TAG, " ")
        Log.d(TAG, "----------------------------${name.uppercase()}--------------------------")
        println( "----------------------------${name.uppercase()}--------------------------")
    }



    fun sum(a: Int, b: Int): Int{
        return a+b
    }

    fun sum2(a: Int, b: Int) = a + b

    fun printSum(a: Int, b: Int): Unit{
        Log.d(TAG,""+a+b)
    }

    fun max(a: Int, b: Int) : Int{
        return if (a > b ) a else b
    }

    fun min(a: Int, b: Int) = if (a < b ) a else b

    fun foo(){
        val a: Int = 1
        val b = 2
        val c:Int
        c = 3
    }

    fun bar (){

        val persons = listOf(Person("Alice"), Person("Bob", age = 29))
        val oldest = persons.maxByOrNull { it.age ?: 0 }
        Log.d(TAG,"Oldest: $oldest")
    }

    fun foo2(){

        // use Color enum
        Log.d(TAG,"Color.BLUE.rgb() = " + BLUE.rgb())

        Log.d(TAG, "Get Mnemonic RED = " + RED.getMnemonic(RED))
        Log.d(TAG, "Get Mnemonic RED = " + BLUE.getMnemonic(RED))

        Log.d(TAG, "getWarmth: "+BLUE.getWarmth(RED))
        Log.d(TAG, "getMyWarmth: "+BLUE.getMyWarmth(BLUE))

        Log.d(TAG, "mix: "+RED.mix(YELLOW, BLUE))
        //Log.d(TAG, "mix: "+RED.mix(BLUE, RED)) // Exception

        Log.d(TAG, "mixOptimized: "+RED.mixOptimized(YELLOW, BLUE))
    }

    private fun markerInterface() {

        Log.d(TAG, "Eval = " + eval(Sum(Sum(Num(1), Num(2)), Num(4))))
        Log.d(TAG, "EvalWithLogging = " + evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
        Log.d(TAG, "Multipl = " + eval(Multipl(Sum(Num(1), Num(2)), Num(4))))
        Log.d(TAG, "MultiplWithLogging = " + evalWithLogging(Multipl(Sum(Num(1), Num(2)), Num(4))))
    }

    fun eval (e: Expr) : Int {

        if (e is Num){
            val n = e as Num
            return n.value
        }

        if (e is Sum){
            return eval(e.left) + eval(e.right)
        }

        if (e is Multipl) return eval(e.left) * eval(e.right)

        throw IllegalArgumentException("Unknow expression")
    }

    fun evalWithLogging(e: Expr): Int =

        when (e) {

            is Num -> {
                Log.d(TAG, "num = ${e.value}")
                e.value
            }

            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                Log.d(TAG, "sum $left + $right")
                left + right
            }

            is Multipl -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                Log.d(TAG, "multiple $left * $right")
                left * right
            }

            else -> throw IllegalArgumentException("Unknow expression")
        }

    fun whileLoops(){

        val sb = StringBuilder()

        var a = 0

        while (a<10){
            if (!sb.isEmpty()) sb.append(" ")
            sb.append("a = $a")
            a++
        }

        Log.d(TAG, "while loop "+sb)

        sb.clear()

        do{
            if (!sb.isEmpty()) sb.append(" ")
            sb.append("a = $a")
            a--
        }while (a > 0)

        Log.d(TAG, "do-while loop "+sb)
    }

    private fun forLoops() {

        val sb =  StringBuilder()

        for (i in 1..50) {
            if (!sb.isEmpty()) sb.append(" ")
            sb.append(fizzBuzz(i))
        }

        Log.d(TAG, "for loop increase "+sb)

        sb.clear()

        for (i in 50 downTo 1 step 2) {
            if (!sb.isEmpty()) sb.append(" ")
            sb.append(fizzBuzz(i))
        }

        Log.d(TAG,"for loop decrease "+sb)

        sb.clear()

        for ( i in 1 until 10){
            if (!sb.isEmpty()) sb.append(" ")
            sb.append("$i")
        }

        Log.d(TAG,"for loop increase until "+sb)
    }

    fun dictionaryIterators(){

        Log.d(TAG, "ASCII Dictionary Iterator")

        val binaryReps = TreeMap<Char, String>()

        for (c in 'A'..'F'){
            binaryReps[c] = Integer.toBinaryString(c.toInt())
        }

        for ((letter, binary) in binaryReps) {
            Log.d(TAG, "$letter = $binary")
        }

        Log.d(TAG, "Number dictionary Iterator")

        val list = arrayListOf("10","11","1001")

        for ((index, element) in list.withIndex()) {
            Log.d(TAG, "index $index = $element")
        }
    }

    fun fizzBuzz(i : Int) = when {

        i % 15 == 0 -> "FizzBuzz"
        i % 5 == 0 -> "Fizz"
        i % 3 == 0 -> "Buzz"
        else -> "$i"
    }

    private fun welcomeBack() {
        Log.d(TAG,"С возвращением!")
    }

    private fun untilLoop() {

        val sb =  StringBuilder()

        for (a in -10 until 10){
            if (!sb.isEmpty()) sb.append(" ")
            sb.append(a)
        }

        Log.d(TAG, "untilLoop: "+sb)
    }

    private fun breaks() {
        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop // non-local return from the lambda passed to run
                Log.d(TAG, it.toString())
            }
        }
        Log.d(TAG," done with nested loop")
    }

    private fun rangeTest(){
        Log.d(TAG,"q is letter: "+isLetter('q'))
        Log.d(TAG,"q is not digit: "+isNotDigit('q'))
        Log.d(TAG,"3 is letter: "+isLetter('3'))
        Log.d(TAG,"3 is not digit: "+isNotDigit('3'))
        Log.d(TAG,"recognize 387: "+recognize('3'))
        Log.d(TAG,"recognize e: "+recognize('e'))

    }

    private fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
    private fun isNotDigit(c: Char) = c !in '0'..'9'

    private fun recognize(c: Char) = when(c){
        in '0'..'9' -> "It's a digest!"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
        else -> "I don't know"
    }

    private fun collections1(){
        Log.d(TAG, " ")
        Log.d(TAG, "Collections")
        Log.d(TAG, "------------------------------------------------------------------------")
        val set = hashSetOf(1,7,53)
        val list = arrayListOf(1,5,7)
        val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

        Log.d(TAG,set.javaClass.toString())
        Log.d(TAG,list.javaClass.toString())
        Log.d(TAG,map.javaClass.toString())

        val strings = listOf("one", "two", "three")

        Log.d(TAG, strings.last())

        val numbers = setOf(1,4,5)
        Log.d(TAG, "max "+numbers.maxOrNull())

        val myList = listOf(1,2,3)
        Log.d(TAG, myList.toString())

        Log.d(TAG,joinToStringStart(list, "; ", "(", ")"))
        Log.d(TAG,myList.joinToString1 (separator = "; ", prefix = "(", postfix = ")"))
        Log.d(TAG,myList.joinToString1 (postfix = ";", prefix = "# "))
        Log.d(TAG,myList.joinToString2 (postfix = ";", prefix = "--- "))
        Log.d(TAG,joinToStringStart2 (list, "; ", "(", ")"))

        Log.d(TAG, "This is my lastChar".last().toString())

        Log.d(TAG, listOf("one","two","eight").join(" "))

        Log.d(TAG, "This is my lastChar2".lastChar2.toString())

        val sb =  StringBuilder("Hello!")
        sb.last ='*'
        Log.d(TAG,sb.toString())

    }

    fun <T> joinToStringStart(collection: Collection<T>, separator: String, prefix: String, postfix: String): String {

        val result = StringBuilder(prefix)

        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }

        result.append(postfix)
        return result.toString()
    }

    fun <T> Collection<T>.joinToString1(separator: String = ", ", prefix: String = "", postfix: String = ""): String {
        val result = StringBuilder(prefix)

        for ((index, element) in this.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }

        result.append(postfix)
        return result.toString()
    }

    private fun collections2(){
        spreadParams(arrayOf("qwe","asd","zxc"))

        val myMap = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three", 22.to("twenty-two"))

        for ((int, value) in myMap) {
            Log.d(TAG,"key $int value: $value")
        }

        val (number, name) = 1 to "one"

        Log.d(TAG,"number = $number name = $name")
    }

    private fun spreadParams(args: Array<String>){
        val list = listOf("args: ", *args)
        Log.d(TAG, list.toString())
    }

    //private infix fun Any.to(other: Any) = Pair(this, other)

    private fun stringsRegex(){
        printSeparator("strings_Regex")

        val str1 = "12.3455-6.A"

        Log.d(TAG,"Regex1 ${str1.split("\\.|-".toRegex())}")
        Log.d(TAG,"Regex2 ${str1.split("[.\\-]".toRegex())}")
        Log.d(TAG, "Regex3 ${str1.split(".","-")}")
        Log.d(TAG, "Regex4 ${str1.split('.','-')}")

        val path = "C:/Program Files/XnViewMP/AddOn/Masks/Thanks to PhotoFiltre.txt"
        val path2 = """C:\Program Files\WinMerge\WinMergeU.exe"""

        parsePath(path)
        parsePath(path2)

        val kotlinLogo = """| //
                   .|//
                   .|/ \"""

        Log.d(TAG, kotlinLogo.trimMargin())

    }

    private fun parsePath(path: String){

        val directory = path.substringBeforeLast("/")
        val fullName = path.substringAfterLast("/")

        val fileName = fullName.substringBeforeLast(".")
        val extension = fullName.substringAfterLast(".")

        Log.d(TAG, "Full path: $path")
        Log.d(TAG, "directory: $directory \nfullname: $fullName \nfilename: $fileName \nextension: $extension")
    }

    private fun localFunctions(){
        printSeparator("local_functions")
        val user1 = User(1,"Misha","Earth")
        val user2 = User(2,"","Moon")

        saveUser(user1)
        saveUser(user2)
    }

    private fun saveUser(user: User){

        /*fun validate(value: String, fieldName: String){
            if (value.isEmpty()) MyLog("Can't create user ${user.id}: empty $fieldName") else MyLog("user ${user.id} ok")
        }

        validate(user.name, "Name")
        validate(user.address, "Address")*/

        user.validateBeforeSave()
    }

    private fun User.validateBeforeSave(){

        fun validate(value: String, fieldName: String){
            if (value.isEmpty()) MyLog("Can't create user $id: empty $fieldName") else MyLog("user $id $fieldName ok!")
        }

        validate(name, "Name")
        validate(address, "Address")
    }

    private fun classes (){
        printSeparator("classes")

        val myButton = MyButton()

        myButton.click()
        myButton.setFocus(true)
        myButton.showOff()

        myButton.setFocus(false)

        val myAnim = MyAnimated()

        val user2 = User2("user2","name1")
        val user3 = User3("user3")

        val user5 = User5("Alice")

        Log.d(TAG2,"user ${user5.nickname} is Subscibed: ${user5.isSubscribed}")

        Log.d(TAG,PrivateUser("test@me.ru").nickname)
        Log.d(TAG,FacebookUser(33,"test3@me.ru").nickname)

        val user = User7("Alice")
        user.address = "Bor"

        val lenghtCounter  =LenghtCounter()
        lenghtCounter.addWord("hello")
        Log.d(TAG, "lenght counter ${lenghtCounter.counter}")

        Log.d(TAG,Client("me", 110100).toString())

        val client1 = Client("Alice",123)
        val client2 = Client("Alice",123)

        Log.d(TAG, "equals: ${client1 == client2}")

        val collection = hashSetOf(client1)

        Log.d(TAG, "Collection contains ${collection.contains(client2)}")

        val dataClient1 = DataClient("Bob", 123)
        val dataClient2 = DataClient("Bob", 123)

        val collection2 = hashSetOf(dataClient1)

        Log.d(TAG, "Collection2 contains ${collection2.contains(dataClient2)}")

        val dataClient3 = dataClient1.copy(postalCode = 111222)

        Log.d(TAG,"Copy result : $dataClient3")

        val cset = CountingSet<Int>()
        cset.addAll(listOf(1,1,3))
        Log.d(TAG,"${cset.objectsAdded} objects were added, ${cset.size} remain")

        Payroll.allEmployees.add(Person("Mikhail", 43))
        Payroll.calculateSalary()

        val persons = listOf(Person("Bob"), Person("Alice"))
        Log.d(TAG,"Sorted ${persons.sortedWith(Person.NameComparator)}")

        A.bar()

        val subscribingUser = CompanionUser("Me")
        val facebookUser = CompanionUser(33)

        val subscribingUser2 = CompanionUser.newSubscribingUser("re@qw.ru")
        val subscribingUser3 = CompanionUser.newFacebookUser(456)

    }

    fun lambdas(){
        printSeparator("lambdas")

        val people = listOf(MyPerson("Alice", 29), MyPerson("Bob", 31), MyPerson("Mike", 45))

        Log.d(TAG, "Max ${people.maxByOrNull{ it.age }}")
        //Log.d(TAG, "Max ${people.maxOfOrNull { Person2::age }}")

        //people.maxBy({p: MyPerson -> p.age})
        Log.d(TAG,"Max 2: ${people.maxByOrNull{ p: MyPerson -> p.age}}")

        val names = people.joinToString(separator = " ", transform = {p: MyPerson -> p.name})

        Log.d(TAG, names)

        val names2 = people.joinToString(" ") {p: MyPerson -> p.name}

        Log.d(TAG, names2)

        val sum = {x: Int, y: Int ->
            Log.d(TAG, "Computing $x ann $y ")
            x + y
        }

        Log.d(TAG, "Sum =  ${sum(1,4)}")

        val errors = listOf("403 Forbidden", "404 Not found")

        printMessagesWithPrefix(errors, "Error")

        val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")

        printProblemCounts(responses)

        run { ::salute }

        val createPerson = ::MyPerson

        val p = createPerson("Alice",29)

        Log.d(TAG, p.toString())

        val list = listOf(1,2,3,4,5,6,7)
        Log.d(TAG, "Euclidean division ${list.filter { it % 2 == 0 }}")

        val doubleList = list.map { it*it }
        Log.d(TAG, "Double list $doubleList")

        val myList = listOf(MyPerson("Alice", 34),MyPerson("Mike", 22),MyPerson("Lena", 22),MyPerson("Bob", 18))

        val maxAge = people.maxByOrNull ( MyPerson::age )?.age
        val myList2 = people.filter { it.age == maxAge }

        Log.d(TAG, "Max age $myList2")

        val canBeInClub27 = {p: MyPerson -> p.age < 27}

        Log.d(TAG, "Club27 ${myList.all(canBeInClub27)}")
        Log.d(TAG, "Club27 ${myList.any(canBeInClub27)}")

        val groupCollection = myList.groupBy { it.age } // LinkedHashMap

        //Log.d(TAG, "Collection type ${groupCollection::class.java.typeName}") // Mis SDK 26
        Log.d(TAG, "Group by age ${groupCollection}")

        val books = listOf(
            Book("Thursday Next", listOf("Jasper Fforde")),
            Book("Mort", listOf("Terry Pratchett")),
            Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman")))

        val foo = books.flatMap { it.autors }.toSet()

        Log.d(TAG, "Autors "+foo)

        val seq1 = myList.asSequence().map( MyPerson::name ).filter { it.startsWith("A") }.toList()
        Log.d(TAG,"Starts with A $seq1")

        val naturalNumbers = generateSequence(0){it+1}
        val numbersTo100 = naturalNumbers.takeWhile {  it <= 100 }

        Log.d(TAG, "Sum 0..100 ${numbersTo100.sum()}")

        Log.d(TAG, alphabet())
        Log.d(TAG, alphabet2())
        Log.d(TAG, "apply ${alphabet3()}")
        Log.d(TAG, alphabet4())

    }

    fun printMessagesWithPrefix( messages: Collection<String>, prefix: String){

        messages.forEach{ Log.d(TAG, "$prefix $it") }
    }

    fun printProblemCounts(responses: Collection<String>) {

        var clientErrors = 0
        var serverErrors = 0

        responses.forEach {
            if (it.startsWith("4")) {
                clientErrors++
            } else if (it.startsWith("5")) {
                serverErrors++
            }
        }

        Log.d(TAG, "$clientErrors client errors, $serverErrors server errors")
    }

    fun salute() = Log.d(TAG, "Salute!")

    fun alphabet(): String{

        val sb = StringBuilder()

        return with(sb){

            for (letter in 'A'..'Z') {
                //this.append(letter)
                append(letter)
            }
            append("\nNow I know the alphabet!")
            //this.toString()
            toString()
        }
    }

    fun alphabet2() = with(StringBuilder()) {

        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
        toString()
    }

    fun alphabet3() = StringBuilder().apply {

        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
    }

    fun alphabet4() = buildString {
        for (c in 'A'..'Z') {
            append(c)
        }
    append(" END")}

    fun TypeSystem(){
        printSeparator("typesystem")

        strLenSafe(null)

        val ceo = Employee("Bob", null)
        val developer = Employee("Mike", ceo)

        Log.d(TAG,"Dev CEO ${managerName(developer)}")
        Log.d(TAG,"CEO CEO ${managerName(ceo)}")

        val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
        val jetbrains = Company("JetBrains", address)
        val person = Person6("Dmitry", jetbrains)

        printShippingLabel(person)
        //printShippingLabel(Person6("Alexey", null))

        val p1 = Person6_1("Dmitry", "Jemerov")
        val p2 = Person6_1("Dmitry", "Jemerov")

        Log.d(TAG, "p1 p1 ${p1 == p2}")
        Log.d(TAG, "42 ${p1.equals(42)}")

        ignoreNulls("qqq")
        //ignoreNulls(null)

        var email: String? = "yole@ya.ru"

        email?.let { sendEmailTo(it) }

        email = null
        email?.let { sendEmailTo(it) }

        verifyUserInput(" ")
        verifyUserInput(null)

        printHashCode(null)
        printHashCode("str")

        showProgress(146)

        val answer: Any = 42

        val collection1 = readNumbers()

        Log.d(TAG, "list $collection1}")

        addValidNumbers(collection1)
        addValidNumbers2(collection1)

        val source: Collection<Int> = arrayListOf(3,5,7)

        val target: MutableCollection<Int> = arrayListOf(1)

        copyElements(source, target)

        Log.d(TAG, "Mutable collection: "+target)

        val letters = Array(26) {i -> ('a'+i).toString()} // не так как в книге
        Log.d(TAG, letters.joinToString { "" })

        val strings = listOf("a", "b", "c")
        Log.d(TAG, "%s/%s/%s".format(*strings.toTypedArray()))
    }

    fun managerName(employee: Employee): String? = employee.manager?.name

    fun strLenSafe(s: String?): Int = if (s != null) s.length else 0

    fun strLenSafe2(s: String?) = s?.length

    fun elvisFoo(s: String?) {
        val t: String = s ?: ""
    }

    fun strLenSafe3(s: String?) = s?.length ?: 0

    fun printShippingLabel(person: Person6){
        val address = person.company?.address ?: throw IllegalArgumentException("No address")
        with(address){
            Log.d(TAG, streetAddress)
            Log.d(TAG, "$zipCode $city $country")
        }
    }

    fun ignoreNulls(s: String?){
        val sNotNull: String = s!!
        Log.d(TAG,"lenght ${sNotNull.length}")
    }

    fun sendEmailTo(email: String) {
        Log.d(TAG,"Sending email to $email")
    }

    fun verifyUserInput(input: String?) {
        if (input.isNullOrBlank()) {
            Log.d(TAG,"Please fill in the required fields")
        }
    }

    fun <T> printHashCode(t: T) {
        Log.d(TAG,t?.hashCode().toString())
    }

    fun <T: Any> printNotNullHashCode(t: T) {
        Log.d(TAG,t.hashCode().toString())
    }

    fun showProgress(progress: Int) {
        val percent = progress.coerceIn(0, 100)
        Log.d(TAG,"We're ${percent}% done!")
    }

    /**
     * Test description
     */
    fun readNumbers(): List<Int?> {

        val numbers = intArrayOf(1,2,3,4,5,6)

        val numbers2 = intArrayOf(8,9,10,11,12,13,14)

        val result = ArrayList<Int?>()

        for (num in numbers) {
            try {
                val number = num
                result.add(number)
            }
            catch(e: NumberFormatException) {
                result.add(null)
            }
        }

        result.add(null)

        for (num in numbers2) {
            try {
                val number = num
                result.add(number)
            }
            catch(e: NumberFormatException) {
                result.add(null)
            }
        }

        result.add(null)

        return result
    }

    /**
     * Посчитать все корректные и не корректные Int'ы
     * @param numbers входящая коллекция
     */
    fun addValidNumbers(numbers: List<Int?>) {

        var sumOfValidNumbers = 0
        var invalidNumbers = 0
        for (number in numbers) {
            if (number != null) {
                sumOfValidNumbers += number
            } else {
                invalidNumbers++
            }
        }
        Log.d(TAG,"Sum of valid numbers $sumOfValidNumbers")
        Log.d(TAG,"Invalid numbers $invalidNumbers")
    }

    fun addValidNumbers2(numbers: List<Int?>){
        val validNumbers = numbers.filterNotNull()
        Log.d(TAG,"Sum of valid numbers ${validNumbers.sum()}")
        Log.d(TAG,"Invalid numbers ${numbers.size - validNumbers.size}")
    }

    fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>){
        for (i in source) {
            target.add(i)
        }
    }

    fun coroutines(){
        printSeparator("Coroutines")

        GlobalScope.launch { // запуск новой сопрограммы в фоне
            delay(1000L) // неблокирующая задержка на 1 секунду
            Log.d(TAG,"World!") // вывод результата после задержки
        }
        Log.d(TAG,"Hello,") // пока сопрограмма проводит вычисления, основной поток продолжает свою работу
        Thread.sleep(1500L)
        Log.d(TAG,"End")
    }

    fun coroutines2() {
        GlobalScope.launch { // запуск новой сопрограммы в фоне
            delay(1000L)
            Log.d(TAG,"World!")
        }
        Log.d(TAG,"Hello,") // основной поток продолжает свою работу
        runBlocking {     // но это выражение блокирует основной поток
            delay(2000L)  // на 2 секунды
        }
        Log.d(TAG,"End")
    }

    fun coroutines3() = runBlocking { // запуск основной сопрограммы
        GlobalScope.launch { // запуск новой сопрограммы в фоне
            delay(1000L)
            println("World!!")
        }
        println("HellO,") // основная сопрограмма продолжает свою работу
        delay(2000L)      // задержка на 2 секунды
        println("END")
    }

    fun coroutines4() = runBlocking {
        val job = GlobalScope.launch { // запуск новой сопрограммы с сохранением ссылки на нее в Job
            delay(1000L)
            println("World_!")
        }
        println("Hello,")
        job.join() // ждем завершения вложенной сопрограммы
        println("END")
    }

    fun coroutines5() = runBlocking { // this: CoroutineScope
        launch { // запуск сопрограммы в области видимости runBlocking
            delay(1000L)
            println("World!!")
        }
        println("Hello,")
    }

    fun coroutines6() = runBlocking { // this: CoroutineScope
        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        coroutineScope { // Создание coroutine scope
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // Эта строка будет выведена перед вложенным launch
        }

        println("Coroutine scope is over") // Эта строка не будет выведена пока не выполнится вложенный launch
    }

    fun coroutines7() = runBlocking {
        launch { doWorld() }
        println("Hello,")
    }

    // это ваша первая функция приостановки
    suspend fun doWorld() {
        delay(1000L)
        println("WoRld!")
    }

    fun coroutines8() = runBlocking {
        (0..10)
        IntRange(0, 100).forEach {
            launch(Dispatchers.IO) {
                delay(10L*it)
                println(it)
            }
        }

        /*repeat(100) { // запуск большого количества сопрограмм
            launch(Dispatchers.IO) {
                delay(1000L)
                println(".")
                Log.d(TAG,"q")
            }
        }*/
    }

    fun coroutines9() = runBlocking {
        GlobalScope.launch {
            repeat(10) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
            println("launch END")
        }
        delay(1300L) // выход после некоторой задержки
        println("END")
    }

    private fun operatorOverloading(){

        printSeparator("operator overloading")

        val p1 = Point(1,2)
        val p2 = Point(3,4)
        println(p1+p2)

        val p3 = Point2(1,2)
        val p4 = Point2(3,4)
        println(p3+p4)

        val p5 = Point(10,15)
        println(p5 * 1.5)

        println('a' * 3)

        var p6 = Point(3,4)
        p6 += Point(1,2)
        println(p6)

        val numbers  = ArrayList<Int>()
        numbers+=42
        println(numbers[0])
        println(numbers)

        val list = arrayListOf(1, 2)
        list += 3
        val newList = list + listOf(4, 5)
        println(list)
        println(newList)

        val p = Point(10, 20)
        println(-p)

        var bd = BigDecimal.ZERO
        println(bd++)
        println(++bd)

        println(Point(10, 20) == Point(10, 20))
        println(Point(10, 20) != Point(5, 5))
        println(null == Point(1, 2))

        val p7 = PersonCh7("Alice", "Smith")
        val p8 = PersonCh7("Bob", "Johnson")
        println("PersonCh7 compare: ${p7 < p8}")

        println("abc" < "bac")

        val p9 = Point(10,22)
        println(p9[1])
        //println(p9[2])

        val p10 = MutablePoint(10, 20)
        p10[1] = 42
        println("Mutable point $p10")

        val rect = Rectangle(Point(10, 20), Point(50, 50))
        println(Point(20, 30) in rect)
        println(Point(5, 5) in rect)

        val now = LocalDate.now()
        val vacation = LocalDate.now() .. now.plusDays(10)
        println("Отпуск удался: ${now.plusWeeks(1) in vacation}")

        val n = 9
        println(0..(n + 1))
        (0..n).forEach { println(it) }


        val newYear = LocalDate.ofYearDay(2017, 15)
        val daysOff = newYear.minusDays(20)..newYear
        for (dayOff in daysOff) { println(dayOff) }

        val p11 = Point(30, 21)
        val (x, y) = p11
        println(x)
        println(y)

        val p12 = FooPoint(1,2)
        val (a,b) = p12

        println("$a and $b")

        val (name, ext) = splitFilename("example.kt")
        println(name)
        println(ext)

        val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")

        printEntries(map)
    }

    operator fun Char.times(count: Int): String{
        return toString().repeat(count)
    }

    /*⠀
           .'\   /`.
         .'.-.`-'.-.`.
    ..._:   .-. .-.   :_...
  .'    '-.(o ) (o ).-'    `.
 :  _    _ _`~(_)~`_ _    _  :
:  /:   ' .-=_   _=-. `   ;\  :
:   :|-.._  '     `  _..-|:   :
 :   `:| |`:-:-.-:-:'| |:'   :
  `.   `.| | | | | | |.'   .'
    `.   `-:_| | |_:-'   .'
      `-._   ````    _.-'
          ``-------''⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⠀⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⢰⠒⠲⡄⠀⡴⠒⠲⠀⢰⠒⠒⠀⠀⠀⣠⠖⠒⠆⠀⢰⠒⢲⡆ ⢀⡴⠒⠲⣄⠀  ⣆⠀⣶⠀⢰⠂⢰⡆⠀⢀⡆⠀ ⡴⠒⠲⣄⠀⠀⠀
⠀⢸⠤⠼⡅⢸⠁⠀⠀⠀⢸⠤⠄⠀⠀⠀⡏⠀⠀⠀⠀  ⡼⠀⢸⡇ ⢸⠁⠀⠀⢸⠀ ⢸⠦⣿⠴⣏⠀⢸⡧⠤⢼⡇ ⢸    ⠀⢸⠀⠀⠀
⠀⢸⣀⣠⠇⠈⢧⣀⣠⠄⢸⣀⣀⠀⠀ ⠻⣄⣀⠄⣰⠇⠀⢸⠇ ⠘⢧⣀⣠⠏  ⡏⠀⢿⠀⠸⡆⢸⡇⠀⠸⡇   ⢧⣀⣠⠞⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀*/
    operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            var current = start

            override fun hasNext() = current <= endInclusive

            override fun next() = current.apply {
                current = plusDays(1)
            }
        }

    fun printEntries(map: Map<String, String>){
        for ((key, value) in map) {
            println("$key -> $value")
        }
    }

    fun lazyInitialization(){
        printSeparator("lazy initialization")

        val p = PersonCh7("Alice", "Smith")
        //p.emails
        p.emails2
        p.emails2

        // Делегирование свойств
        val p2 = PersonProp("Dmitry", 34, 2000)

        p2.addPropertyChangeListener { event ->
            println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
        }

        p2.age = 35
        p2.salary = 2100

        // Делегирование свойств с классом ObservableProperty
        val p3 = PersonProp2("Dmitry", 34, 2000)

        p3.addPropertyChangeListener { event ->
            println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
        }
        p3.age = 35
        p3.salary = 2100

        // делегирование свойств с классом ObservableProperty2 и PersonProp3

        val p4 = PersonProp3("Dmitry", 34, 2000)

        p4.addPropertyChangeListener { event ->
            println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
        }

        p4.age = 35
        p4.salary = 2100

        //  делегирование свойств с классом PersonProp4 и kotlin.properties.Delegates observable

        val p5 = PersonProp4("Dmitry", 34, 2000)

        p5.addPropertyChangeListener { event ->
            println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
        }

        p5.age = 37
        p5.salary = 2200

        // Правило трансляции делегированных свойств

        val p6 = PersonTrans()

        val data = mapOf("name" to "Dmitry", "company" to "JetBrains")

        for ((attrName, value) in data)
            p6.setAttribute(attrName, value)

        println(p6.name)

        // Правило трансляции делегированных свойств

        val p7 = PersonTrans2()

        val data2 = mapOf("name" to "Mikhail", "company" to "JetBrains")

        for ((attrName, value) in data2)
            p7.setAttribute(attrName, value)

        println(p7.name)
    }

    fun highOrderFunctionsAndLambdasChapter8(){
        printSeparator("High-order functions and lambdas")

        twoAndThree{a, b -> a + b}
        twoAndThree{a, b -> a * b}

        println("ab1c".filter { it in 'a'..'z' })

        val letters = listOf("Alpha", "Beta")
        println(letters.joinToString4())

        println(letters.joinToString4 { it.lowercase() })

        println(letters.joinToString4(separator = "! ", postfix = "! ", transform = { it.uppercase() }))

        val letters2 = listOf("Alpha", "Beta", "Gamma")
        println(letters2.joinToString5())
        println(letters2.joinToString5 { it.lowercase() })
        println(letters2.joinToString5(separator = "! ", postfix = "! ", transform = { it.uppercase() }))

        val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
        println("Shipping ${calculator(Order(3))}")

        val calculator2 = getShippingCostCalculator(Delivery.STANDARD)
        println("Shipping ${calculator2(Order(2))}")

        val contacts = listOf(
            ContactPerson("Dmitry", "Jemerov", "123-4567"),
            ContactPerson("Svetlana", "Isakova", null))

        val contactListFilters = ContactListFilters()

        with (contactListFilters) {
            prefix = "Dm"
            onlyWithPhoneNumber = true
        }

        println(contacts.filter(contactListFilters.getPredicate()))

        val log = listOf(
            SiteVisit("/", 34.0, OS.WINDOWS),
            SiteVisit("/", 22.0, OS.MAC),
            SiteVisit("/login", 12.0, OS.WINDOWS),
            SiteVisit("/signup", 8.0, OS.IOS),
            SiteVisit("/", 16.3, OS.ANDROID)
        )

        /*val averageWindowsDuration = log
            .filter { it.os == OS.WINDOWS }
            .map(SiteVisit::duration)
            .average()*/

        //println(averageWindowsDuration)

        println(log.averageDurationFor(OS.WINDOWS))
        println(log.averageDurationFor(OS.MAC))

        val averageMobileDuration = log
            .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
            .map(SiteVisit::duration)
            .average()

        println(averageMobileDuration)

        println(log.averageDurationFor { it.os in setOf(OS.ANDROID, OS.IOS) })
        println(log.averageDurationFor { it.os == OS.IOS && it.path == "/signup" })

        //8.3.1
        val people = listOf(SimplePerson("Alice", 29), SimplePerson("Bob",31))
        lookForAlice(people)
        lookForAlice2(people)
        lookForAlice3(people)
        lookForAlice4(people)
        lookForAlice5(people)
    }

    fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
        filter(predicate).map(SiteVisit::duration).average()

    fun readFirstLineFromFile(path: String): String {
        BufferedReader(FileReader(path)).use { br -> return br.readLine() }
    }

    fun lookForAlice(people: List<SimplePerson>){
        for (person in people) {
            if (person.name == "Alice"){
                println("Found!")
                return
            }
        }
        println("Alice isn't found")
    }

    fun lookForAlice2(people: List<SimplePerson>){
        people.forEach {
            if (it.name == "Alice") {
                println("Found!")
                return
            }
        }
        println("Alice isn't found")
    }

    fun lookForAlice3(people: List<SimplePerson>) {
        people.forEach {
            if (it.name == "Alice") return@forEach
        }
        println("Alice might be somewhere")
    }

    fun lookForAlice4(people: List<SimplePerson>) {
        people.forEach label@{
            if (it.name == "Alice") return@label
        }
        println("Alice might be somewhere")
    }

    fun lookForAlice5(people: List<SimplePerson>) {
        people.forEach(fun (person) {
            if (person.name == "Alice") return
            println("${person.name} is not Alice")
        })
    }

    private fun generics() {
        printSeparator("generics")

        val letters = ('a'..'z').toList()
        println(letters.slice<Char>(0..2))
        println(letters.slice(10..13))

        println(listOf(1,2,3,4,5).penultimate)

        println("onehalf = ${oneHalf(3)}")

        println("max = ${genericMax("kotlin", "java")}")
        println("max = ${genericMax("a", "b")}")

        //println("max = ${max("kotlin", 3)}")

        val helloWorld = StringBuilder("Hello World")
        ensureTrailingPeriod(helloWorld)
        println(helloWorld)

        printCollectionSum(listOf(4,5,6))
        //printCollectionSum(setOf(4,5,6)) // IllegalArgumentException: List is expected
        //printCollectionSum(setOf("a","b","c")) //IllegalArgumentException: List is expected

        printCollectionSum2(listOf(2,3,4))

        println(isA<String>("abc"))
        println(isA<String>(123))

        val items = listOf("one", 2, "three")
        println(items.filterIsInstance<String>())

        println("Happy New Year!")

        val ints = mutableListOf(1,2,3)
        val anyItem = mutableListOf<Any>()
        copyData(ints, anyItem)
        println(anyItem)

        val ints2 = mutableListOf(1,2,3)
        val anyItem2 = mutableListOf<Any>()
        copyData2(ints2, anyItem2)
        println(anyItem)
    }

    fun <T: R, R> copyData(source: MutableList<T>, destination: MutableList<R>){
        for (item in source) {
            destination.add(item)
        }
    }

    fun <T> copyData2(source: MutableList<out T>, destination: MutableList<T>){
        for (item in source){
            destination.add(item)
        }
    }

    private fun reflection(){
        printSeparator("reflection")

    }

    private fun palindrome(){
        printSeparator("palindrome")

        val s1 = "A man, a plan, a canal: Panama"
        val s2 = "race a car"
        val s3 = " "
        val s4 = "a"
        val s5 = "aa"
        val s6 = "aaa"
        val s7 = "Казак"
        val s8 = "А роза упала на лапу Азора"
        val s9 = "Do greese see God"
        val s10 = "Madam, I'm Adam"

        val myList = arrayListOf(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10)

        for (s in myList) {
            println("----------------------------------------------------")
            println(s)
            println("result: "+checkPalindrome(s))
        }
    }

    private fun checkPalindrome(s: String): Boolean {
        s.forEachIndexed({index, char -> println("Index $index, Char: $char")})
        return false
    }
}