import { FaTwitter, FaLinkedin, FaGithub } from "react-icons/fa";

function Footer() {
    return (
        <footer className="bg-gray-900 text-gray-300">
            <div className="max-w-6xl mx-auto px-6 py-10 grid grid-cols-1 md:grid-cols-3 gap-8">

                {/* Brand */}
                <div>
                    <h2 className="text-2xl font-bold text-white">TradeQuick</h2>
                    <p className="mt-3 text-sm text-gray-400">
                        Smart trading made simple. Buy or sell stocks quickly and securely.
                    </p>
                </div>

                {/* Navigation */}
                <div className="flex flex-col md:items-center">
                    <h3 className="text-lg font-semibold text-white">Quick Links</h3>
                    <ul className="mt-3 space-y-2">
                        <li><a href="#" className="hover:text-white transition">Home</a></li>
                        <li><a href="#" className="hover:text-white transition">About</a></li>
                        <li><a href="#" className="hover:text-white transition">Services</a></li>
                        <li><a href="#" className="hover:text-white transition">Contact</a></li>
                    </ul>
                </div>

                {/* Social Links */}
                <div className="flex flex-col md:items-end">
                    <h3 className="text-lg font-semibold text-white">Follow Us</h3>
                    <div className="flex gap-4 mt-3">
                        <a href="#" className="hover:text-white transition"><FaTwitter size={20} /></a>
                        <a href="#" className="hover:text-white transition"><FaLinkedin size={20} /></a>
                        <a href="#" className="hover:text-white transition"><FaGithub size={20} /></a>
                    </div>
                </div>
            </div>

            {/* Bottom Bar */}
            <div className="border-t border-gray-700 py-4 text-center text-sm text-gray-500">
                © {new Date().getFullYear()} TradeQuick. All rights reserved.
            </div>
        </footer>
    );
}

export default Footer;
