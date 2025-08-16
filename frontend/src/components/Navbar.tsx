

function Navbar() {
    return (
        <>
            <div className="flex flex-row items-center justify-center bg-amber-800 w-[300px]">
                <div>Logo</div>

                <div >
                    <ul className="flex flex-row justify-between"><li>Home</li>
                        <li>ABout</li></ul>
                </div>
            </div>
        </>
    )
}

export default Navbar