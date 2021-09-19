package com.carlyadam.workout.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.carlyadam.notifications_domain.NotificationData
import com.carlyadam.notifications_presentation.notifications.NotificationsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private val postViewModel: NotificationsViewModel by viewModels()

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            addPostList(postViewModel)
        }

        getData()
    }

    private fun getData() {
        lifecycleScope.launch {
            postViewModel.notifications()
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun addPostList(postViewModel: NotificationsViewModel) {
    val response by postViewModel.responseNotificationsLiveData.observeAsState()
    val error by postViewModel.errorLiveData.observeAsState()

    response?.let {
        showPosts(it)
    }

    error?.let {
        showError(error!!)
    }
}

@ExperimentalMaterialApi
@Composable
fun showPosts(postList: List<NotificationData>) {
    MaterialTheme {
        Column {
            postList.forEach {
                MaterialCardComponent(it)
            }
        }
    }
}

@Composable
fun showError(error: String) {
    Log.i("REEEEES", error)
    //Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
}

@ExperimentalMaterialApi
@Composable
fun MaterialCardComponent(notificationData: NotificationData) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .clickable(
                onClick = {
                }
            )
            .padding(8.dp)
    ) {
        ListItem(
            text = {
                Text(text = notificationData.notification.title)
            },
            secondaryText = {
                Text(text = notificationData.notification.body)
            }
        )
    }
}