import { Link } from "react-router-dom";

function Navbar() {
    const navList = [
        { name: "Trending", href: "/trending" },
        { name: "Volume", href: "/volume" },
        { name: "Best Picks", href: "/best-picks" },
    ];

    return (
        <header className="sticky top-2 z-50 mx-auto w-[600px] rounded-2xl border border-gray-200 bg-white/70 shadow-md backdrop-blur-md">
            <nav className="flex items-center justify-between px-4 py-2">
                {/* Logo */}
                <div className="text-xl font-bold text-cyan-600 tracking-wide">
                    <Link to="/">MyLogo</Link>
                </div>

                {/* Nav Links */}
                <ul className="flex items-center space-x-6">
                    {navList.map((item, index) => (
                        <li key={index}>
                            <Link
                                to={item.href}
                                className="text-gray-700 transition-colors hover:text-cyan-600 font-medium"
                            >
                                {item.name}
                            </Link>
                        </li>
                    ))}
                </ul>

                {/* Profile */}
                <div className="h-9 w-9 overflow-hidden rounded-full border border-gray-300 shadow-sm">
                    <img
                        src="../assets/profile.jpg"
                        alt="Profile"
                        className="h-full w-full object-cover"
                    />
                </div>
            </nav>
        </header>
    );
}

export default Navbar;
