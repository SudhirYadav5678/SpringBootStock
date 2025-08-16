import React, { type ReactNode } from 'react'

function Container({ children }: { children: ReactNode }) {
    return (
        <div className='w-full h-full'>
            {children}
        </div>
    );
}

export default Container;