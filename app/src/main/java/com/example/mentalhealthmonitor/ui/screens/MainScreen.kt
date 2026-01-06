@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable(Screen.Home.route) {
                HomeScreen()
            }

            composable(Screen.Dashboard.route) {
                HomeDashboardScreen()
            }

            composable(Screen.Insight.route) {
                ExplainableInsightScreen()
            }

            composable(Screen.Progress.route) {
                ProgressScreen()
            }
        }
    }
}

