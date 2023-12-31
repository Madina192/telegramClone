package com.example.telegram.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.telegram.R
import com.example.telegram.ui.fragments.SettingsFragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem


class AppDrawer(val mainActivity : AppCompatActivity, private val toolbar: Toolbar) {

    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader

    fun create () {
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(mainActivity)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("New Group")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_new_group),
                PrimaryDrawerItem().withIdentifier(101)
                    .withIconTintingEnabled(true)
                    .withName("New Secret Chat")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_lock),
                PrimaryDrawerItem().withIdentifier(102)
                    .withIconTintingEnabled(true)
                    .withName("New Channel")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_new_channel),
                PrimaryDrawerItem().withIdentifier(103)
                    .withIconTintingEnabled(true)
                    .withName("Contacts")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_person),
                PrimaryDrawerItem().withIdentifier(104)
                    .withIconTintingEnabled(true)
                    .withName("Calls")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_phone),
                PrimaryDrawerItem().withIdentifier(105)
                    .withIconTintingEnabled(true)
                    .withName("Saved Messages")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_saved_messages),
                PrimaryDrawerItem().withIdentifier(106)
                    .withIconTintingEnabled(true)
                    .withName("Settings")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_settings),
                DividerDrawerItem(),
                PrimaryDrawerItem().withIdentifier(107)
                    .withIconTintingEnabled(true)
                    .withName("Invite Friends")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_person_add),
                PrimaryDrawerItem().withIdentifier(108)
                    .withIconTintingEnabled(true)
                    .withName("Telegram FAQ")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_help)
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when (position) {
                        7 -> mainActivity.supportFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.data_container, SettingsFragment()).commit()
                    }
                    return false
                }

            }).build()
    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
            .withActivity(mainActivity)
            .withHeaderBackground(R.color.colorPrimary) //i used color instead of drawable
            .addProfiles(
                ProfileDrawerItem().withName("Madina Akpaeva")
                    .withEmail("+996708131700") //madinaakpaeva000@gmail.com - email, but usually we can see user's number there
            ).build()
    }
}