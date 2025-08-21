import { type ReactNode } from "react";
import { twMerge } from "tailwind-merge";

function Container({ children, className }: { children: ReactNode; className?: string }) {
    return (
        <div className={twMerge("max-w-7xl h-screen mx-auto mt-2 font-sans ", className)}>
            {children}
        </div>
    );
}

export default Container;
