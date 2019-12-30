package ru.godsonpeya.viewpager2tablayout


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        val viewPager2: ViewPager2 = view.findViewById(R.id.viewPager)

        viewPager2.adapter = PageAdapter(this.requireActivity())

        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout)

        TabLayoutMediator(tabLayout, viewPager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "Confirmed"
                        tab.setIcon(R.drawable.ic_pending)
                        val badgeDrawable: BadgeDrawable = tab.orCreateBadge;
                        badgeDrawable.backgroundColor = ContextCompat.getColor(
                            context?.applicationContext!!,
                            R.color.colorAccent
                        )
                        badgeDrawable.isVisible = true
                    }
                    1 -> {
                        tab.text = "Pending"
                        tab.setIcon(R.drawable.ic_confirmed)
                    }
                    2 -> {
                        tab.text = "Delivered"
                        tab.setIcon(R.drawable.ic_delivered)
                        val badgeDrawable: BadgeDrawable = tab.orCreateBadge;
                        badgeDrawable.backgroundColor = ContextCompat.getColor(
                            context?.applicationContext!!,
                            R.color.colorAccent
                        )
                        badgeDrawable.isVisible = true
                        badgeDrawable.number = 100
                    }
                }
            }).attach()


        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val badgeDrawable: BadgeDrawable? = tabLayout.getTabAt(position)?.orCreateBadge

                if (badgeDrawable != null)
                    badgeDrawable.isVisible = false

            }
        })
        return view
    }


}
