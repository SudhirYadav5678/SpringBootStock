import Container from "../components/Container"
import stockImg from "../assets/pexels-alesiakozik-6770610.jpg"; // <-- replace with any stock/finance image in assets

function Home() {
    return (
        <Container>
            <div className="bg-gradient-to-b from-white via-gray-50 to-purple-100 w-full min-h-screen flex items-center justify-center">
                <div className="grid grid-cols-1 md:grid-cols-2 gap-12 max-w-6xl px-6 py-12 md:py-20 items-center">

                    {/* Left Content */}
                    <div className="text-center md:text-left space-y-6">
                        <h1 className="text-3xl sm:text-4xl md:text-5xl lg:text-6xl font-extrabold tracking-tight leading-tight">
                            <span className="bg-gradient-to-r from-blue-600 to-purple-600 bg-clip-text text-transparent">
                                Trade Smarter, Faster
                            </span>
                        </h1>

                        <p className="text-base sm:text-lg md:text-xl text-gray-700 max-w-lg mx-auto md:mx-0">
                            Join thousands of investors taking their first step into smarter trading.
                            Buy or sell with confidence in seconds.
                        </p>

                        {/* Buttons */}
                        <div className="flex flex-col sm:flex-row gap-4 mt-6 justify-center md:justify-start">
                            <button className="px-6 py-3 rounded-xl font-semibold bg-blue-600 text-white shadow-lg hover:bg-blue-700 transition">
                                Explore Stocks
                            </button>
                            <button className="px-6 py-3 rounded-xl font-semibold border border-gray-300 bg-white text-gray-900 shadow-sm hover:shadow-md hover:bg-gray-50 transition">
                                View Top Picks
                            </button>
                        </div>
                    </div>

                    {/* Right Image inside Box */}
                    <div className="flex justify-center md:justify-end">
                        <div className="w-full max-w-sm sm:max-w-md lg:max-w-lg h-72 md:h-96 rounded-2xl shadow-2xl overflow-hidden relative">
                            <img
                                src={stockImg}
                                alt="Stock market preview"
                                className="w-full h-full object-cover object-center transform hover:scale-110 transition duration-700"
                            />
                            {/* Optional overlay for depth */}
                            <div className="absolute inset-0 bg-gradient-to-t from-black/40 via-transparent to-transparent"></div>
                        </div>
                    </div>
                </div>
            </div>
        </Container>
    )
}

export default Home
