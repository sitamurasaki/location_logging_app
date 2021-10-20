package app.gkuroda.mylocationlogging

import android.os.Bundle
import app.gkuroda.mylocationlogging.dagger.viewModel.ViewModelFactory
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : RxAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

    }
}