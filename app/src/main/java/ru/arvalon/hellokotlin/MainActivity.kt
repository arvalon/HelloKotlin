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
import ru.arvalon.hellokotlin.model.Person

import ru.arvalon.hellokotlin.book.ch2.Color.*
import ru.arvalon.hellokotlin.book.ch2.Expr
import ru.arvalon.hellokotlin.book.ch2.Expr.Num
import ru.arvalon.hellokotlin.book.ch2.Expr.Sum
import ru.arvalon.hellokotlin.book.ch2.Expr.Multipl
import ru.arvalon.hellokotlin.book.ch4.*
import ru.arvalon.hellokotlin.book.h5.Book
import ru.arvalon.hellokotlin.book.h5.MyPerson
import ru.arvalon.hellokotlin.model.User
import strings.join
import strings.joinToString2
import strings.joinToStringStart2
import strings.lastChar2
import strings.lastChar as last
import java.util.*

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

        //rangeTest()

        //printSeparator("Collections")

        //collections1()

        //collections2()

        //stringsRegex()

        //localFunctions()

        //classes()

        lambdas()

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
}