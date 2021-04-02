package com.jakehamby.blackjack

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jakehamby.blackjack.ui.theme.BlackjackTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlackjackTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Green) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.app_name))
                }
            )
        },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
                    .padding(16.dp),
                content = {
                    Text(
                        text = stringResource(R.string.game_welcome),
                        style = MaterialTheme.typography.h3,
                        textAlign = TextAlign.Center
                    )
                    Column(
                        content = {
                            Text(
                                text = stringResource(
                                    R.string.player_balance,
                                    "500"
                                ),
                                style = MaterialTheme.typography.h5
                            )
                            Text(
                                text = stringResource(
                                    R.string.number_of_decks,
                                    "4"
                                ),
                                style = MaterialTheme.typography.h5
                            )
                            Text(
                                text = stringResource(
                                    R.string.shuffle_percent,
                                    "50"
                                ),
                                style = MaterialTheme.typography.h5
                            )
                            Text(
                                text = stringResource(
                                    R.string.deal_speed,
                                    "2"
                                ),
                                style = MaterialTheme.typography.h5
                            )
                        }
                    )
                    Column(
                        content = {
                            Button(onClick = {
                                // play game
                            }) {
                                Text(
                                    text = stringResource(R.string.play_game_label),
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                            Button(onClick = {
                                // game rules
                            }) {
                                Text(
                                    text = stringResource(R.string.game_rules_label),
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                            Button(onClick = {
                                // settings
                            }) {
                                Text(
                                    text = stringResource(R.string.settings_label),
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }
                    )
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BlackjackTheme {
        HomeScreen()
    }
}